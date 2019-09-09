package com.example.muhammad.prediksihargarumputlaut;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class InputActivity extends AppCompatActivity {

    Button btn1;
    EditText txt1,txt2,txt3,txt4,txt5,txt6;
    double alpha = 0.2;
    double alpha1 = 0.8;
    double alpha2 = 0.25;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        btn1 = (Button) findViewById(R.id.btn);
        txt1 = (EditText) findViewById(R.id.periode1);
        txt2 = (EditText) findViewById(R.id.periode2);
        txt3 = (EditText) findViewById(R.id.periode3);
        txt4 = (EditText) findViewById(R.id.periode4);
        txt5 = (EditText) findViewById(R.id.periode5);
        txt6 = (EditText) findViewById(R.id.periode6);
    }

    public void cekHasil(View view) {
        String periode1 = txt1.getText().toString().trim();
        String periode2 = txt2.getText().toString().trim();
        String periode3 = txt3.getText().toString().trim();
        String periode4 = txt4.getText().toString().trim();
        String periode5 = txt5.getText().toString().trim();
        String periode6 = txt6.getText().toString().trim();

        if (txt1.getText().toString().equals("")||txt2.getText().toString().equals("")||txt3.getText().toString().equals("")||
                txt4.getText().toString().equals("")||txt5.getText().toString().equals("")||txt6.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Mohon untuk melengkapi data",Toast.LENGTH_SHORT).show();
        }
        else {
            double hitung1 = Double.parseDouble(periode1);
            double hitung2 = Double.parseDouble(periode2);
            double hitung3 = Double.parseDouble(periode3);
            double hitung4 = Double.parseDouble(periode4);
            double hitung5 = Double.parseDouble(periode5);
            double hitung6 = Double.parseDouble(periode6);

            //RUMUS SIMPLE MOVING AVERAGE
            double ma2 = (hitung4+hitung3+hitung2)/3;
            double ma3 = (hitung5+hitung4+hitung3)/3;
            double ma4 = (hitung6+hitung5+hitung4)/3;

            //RUMUS DOUBLE MOVING AVERAGE
            double dma = (ma2+ma3+ma4)/3;

            //RUMUS TIGA BULAN
            double sdma = (ma4*3)-(dma*2);
            double sdma2 = (ma4*4)-(dma*3);
            double sdma3 = (ma4*5)-(dma*4);

            //RUMUS EXPONENTIAL SMOOTHING
            double es = hitung1;
            double es2 = alpha*hitung2+alpha1*es;
            double es3 = alpha*hitung3+alpha1*es2;
            double es4 = alpha*hitung4+alpha1*es3;
            double es5 = alpha*hitung5+alpha1*es4;
            double es6 = alpha*hitung6+alpha1*es5;

            //RUMUS DOUBLE EXPONENTIAL SMOOTHING
            double des = hitung1;
            double des2= alpha*es2+alpha1*des;
            double des3= alpha*es3+alpha1*des2;
            double des4= alpha*es4+alpha1*des3;
            double des5= alpha*es5+alpha1*des4;
            double des6= alpha*es6+alpha1*des5;

            //RUMUS DOUBLE EXPONENTIAL SMOOTHING WITH BROWN
            double desb = es6*(2+(alpha2)*1)-des6*(1+(alpha2)*1);
            double desb2 = es6*(2+(alpha2)*2)-des6*(1+(alpha2)*2);
            double desb3 = es6*(2+(alpha2)*3)-des6*(1+(alpha2)*3);


            //RUMUS NAIVE METHOD
            double naive=hitung6;

            //pembulatan
            DecimalFormat a = new DecimalFormat("#");
            double a1 = Double.valueOf(a.format(sdma));
            double a2 = Double.valueOf(a.format(sdma2));
            double a3 = Double.valueOf(a.format(sdma3));
            double a4 = Double.valueOf(a.format(desb));
            double a5 = Double.valueOf(a.format(desb2));
            double a6 = Double.valueOf(a.format(desb3));

            Intent intent = new Intent(InputActivity.this, HasilActivity.class);

            //KIRIM DATA
            intent.putExtra("EXTRA_MA",a1);
            intent.putExtra("EXTRA_MA2",a2);
            intent.putExtra("EXTRA_MA3",a3);
            intent.putExtra("EXTRA_ES",a4);
            intent.putExtra("EXTRA_ES2",a5);
            intent.putExtra("EXTRA_ES3",a6);
            intent.putExtra("EXTRA_NAIVE",naive);

            startActivity(intent);
        }
    }
}
