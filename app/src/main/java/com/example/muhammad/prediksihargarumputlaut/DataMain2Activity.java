package com.example.muhammad.prediksihargarumputlaut;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataMain2Activity extends AppCompatActivity {

ListView lv;
AlertDialog.Builder dialog;
List<Data> itemList = new ArrayList<Data>();
Adapter adapter;
DbHandler SQLite = new DbHandler(this);
ListAdapter listAdapter;

    public static final String TAG_ID = "id";
    public static final String TAG_MOVING = "moving";
    public static final String TAG_MOVING2 = "moving2";
    public static final String TAG_MOVING3 = "moving3";
    public static final String TAG_SMOOTHING = "smoothing";
    public static final String TAG_SMOOTHING2 = "smoothing2";
    public static final String TAG_SMOOTHING3 = "smoothing3";
    public static final String TAG_NAIVE = "naive";
    public static final String TAG_NAIVE2 = "naive2";
    public static final String TAG_NAIVE3 = "naive3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_main2);
        ListView lv = (ListView)findViewById(R.id.list_data);
        lv.setLongClickable(true);

        SQLite = new DbHandler(getApplicationContext());

        adapter = new Adapter(DataMain2Activity.this, itemList);
        lv.setAdapter(adapter);

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, final long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(DataMain2Activity.this);
                builder.setMessage("MAU HAPUS ?")
                        .setNegativeButton("BATAL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                            }
                        })
                        .setPositiveButton("HAPUS", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                DbHandler helper = new DbHandler(DataMain2Activity.this);
                                helper.DeleteUser(position);
                                helper.close();
                                Intent intent = new Intent(DataMain2Activity.this, DataMain2Activity.class);
                                startActivity(intent);
                            }
                        });
                builder.show();
                return true;
            }

        });

        //baru


    }

    private void GetUsers(){
        ArrayList<HashMap<String, String>> row = SQLite.GetUsers();

        for (int i = 0; i < row.size(); i++) {
            String id = row.get(i).get(TAG_ID);
            String moving = row.get(i).get(TAG_MOVING);
            String moving2 = row.get(i).get(TAG_MOVING2);
            String moving3 = row.get(i).get(TAG_MOVING3);
            String smoothing = row.get(i).get(TAG_SMOOTHING);
            String smoothing2 = row.get(i).get(TAG_SMOOTHING2);
            String smoothing3 = row.get(i).get(TAG_SMOOTHING3);
            String naive = row.get(i).get(TAG_NAIVE);
            String naive2 = row.get(i).get(TAG_NAIVE2);
            String naive3 = row.get(i).get(TAG_NAIVE3);

            Data data = new Data();

            data.setId(id);
            data.setMoving(moving);
            data.setMoving2(moving2);
            data.setMoving3(moving3);
            data.setSmoothing(smoothing);
            data.setSmoothing2(smoothing2);
            data.setSmoothing3(smoothing3);
            data.setNaive(naive);
            data.setNaive2(naive2);
            data.setNaive3(naive3);

            itemList.add(data);
        }

        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        itemList.clear();
        GetUsers();
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}

