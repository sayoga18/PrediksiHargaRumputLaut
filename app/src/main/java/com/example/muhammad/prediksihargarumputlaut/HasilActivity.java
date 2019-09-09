package com.example.muhammad.prediksihargarumputlaut;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HasilActivity extends AppCompatActivity {

    Button btn;
    TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9;
    double ma,ma2,ma3,exponen,exponen2,exponen3,naive,naive2,naive3;
    double defaultValue = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        txt1 = (TextView)findViewById(R.id.jawaban_ma);
        txt2 = (TextView)findViewById(R.id.jawaban_ma2);
        txt3 = (TextView)findViewById(R.id.jawaban_ma3);
        txt4 = (TextView)findViewById(R.id.jawaban_exponen);
        txt5 = (TextView)findViewById(R.id.jawaban_exponen2);
        txt6 = (TextView)findViewById(R.id.jawaban_exponen3);
        txt7 = (TextView)findViewById(R.id.jawaban_naive);
        txt8 = (TextView)findViewById(R.id.jawaban_naive2);
        txt9 = (TextView)findViewById(R.id.jawaban_naive3);
        btn = (Button)findViewById(R.id.btn_simpan);


        Intent intent = getIntent();
        ma=intent.getDoubleExtra("EXTRA_MA",defaultValue);
        ma2=intent.getDoubleExtra("EXTRA_MA2",defaultValue);
        ma3=intent.getDoubleExtra("EXTRA_MA3",defaultValue);
        exponen=intent.getDoubleExtra("EXTRA_ES",defaultValue);
        exponen2=intent.getDoubleExtra("EXTRA_ES2",defaultValue);
        exponen3=intent.getDoubleExtra("EXTRA_ES3",defaultValue);
        naive=intent.getDoubleExtra("EXTRA_NAIVE",defaultValue);
        naive2=intent.getDoubleExtra("EXTRA_NAIVE",defaultValue);
        naive3=intent.getDoubleExtra("EXTRA_NAIVE",defaultValue);

        txt1.setText(" "+ma);
        txt2.setText(" "+ma2);
        txt3.setText(" "+ma3);
        txt4.setText(" "+exponen);
        txt5.setText(" "+exponen2);
        txt6.setText(" "+exponen3);
        txt7.setText(" "+naive);
        txt8.setText(" "+naive2);
        txt9.setText(" "+naive3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(HasilActivity.this, DataMain2Activity.class);
                String data1 = txt1.getText().toString()+"\n";
                String data2 = txt2.getText().toString();
                String data3 = txt3.getText().toString();
                String data4 = txt4.getText().toString();
                String data5 = txt5.getText().toString();
                String data6 = txt6.getText().toString();
                String data7 = txt7.getText().toString();
                String data8 = txt8.getText().toString();
                String data9 = txt9.getText().toString();
                DbHandler dbHandler = new DbHandler(HasilActivity.this);
                dbHandler.insertUserDetails(data1,data2,data3,data4,data5,data6,data7,data8,data9);
                startActivity(intent1);
                Toast.makeText(getApplicationContext(),"TERSIMPAN",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
