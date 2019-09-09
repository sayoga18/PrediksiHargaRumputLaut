package com.example.muhammad.prediksihargarumputlaut;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DbHandler extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "prediksi";
    private static final String TABLE_Users = "rumputlaut";
    private static final String KEY_ID = "id";
    private static final String KEY_MOVING = "moving";
    private static final String KEY_MOVING2 = "moving2";
    private static final String KEY_MOVING3 = "moving3";
    private static final String KEY_SMOOTHING = "smoothing";
    private static final String KEY_SMOOTHING2 = "smoothing2";
    private static final String KEY_SMOOTHING3 = "smoothing3";
    private static final String KEY_NAIVE = "naive";
    private static final String KEY_NAIVE2 = "naive2";
    private static final String KEY_NAIVE3 = "naive3";
    public DbHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_Users + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_MOVING + " TEXT,"
                + KEY_MOVING2 + " TEXT,"
                + KEY_MOVING3 + " TEXT,"
                + KEY_SMOOTHING + " TEXT,"
                + KEY_SMOOTHING2 + " TEXT,"
                + KEY_SMOOTHING3 + " TEXT,"
                + KEY_NAIVE + " TEXT,"
                + KEY_NAIVE2 + " TEXT,"
                + KEY_NAIVE3 + " TEXT"+ ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_Users);
        onCreate(db);
    }

    void insertUserDetails(String a, String b, String c,String d,String e, String f, String g, String h, String i) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cValues = new ContentValues();
        cValues.put(KEY_MOVING, a);
        cValues.put(KEY_MOVING2, b);
        cValues.put(KEY_MOVING3, c);
        cValues.put(KEY_SMOOTHING, d);
        cValues.put(KEY_SMOOTHING2, e);
        cValues.put(KEY_SMOOTHING3, f);
        cValues.put(KEY_NAIVE, g);
        cValues.put(KEY_NAIVE2, h);
        cValues.put(KEY_NAIVE3, i);

        long newRowId = db.insert(TABLE_Users, null, cValues);
        db.close();
    }

    public ArrayList<HashMap<String, String>> GetUsers(){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        String query = "SELECT moving, moving2, moving3, smoothing, smoothing2, smoothing3, naive, naive2, naive3 FROM "+ TABLE_Users;
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()){
            HashMap<String,String> user = new HashMap<>();
            user.put("moving", cursor.getString(cursor.getColumnIndex(KEY_MOVING)));
            user.put("moving2", cursor.getString(cursor.getColumnIndex(KEY_MOVING2)));
            user.put("moving3", cursor.getString(cursor.getColumnIndex(KEY_MOVING3)));
            user.put("smoothing", cursor.getString(cursor.getColumnIndex(KEY_SMOOTHING)));
            user.put("smoothing2", cursor.getString(cursor.getColumnIndex(KEY_SMOOTHING2)));
            user.put("smoothing3", cursor.getString(cursor.getColumnIndex(KEY_SMOOTHING3)));
            user.put("naive", cursor.getString(cursor.getColumnIndex(KEY_NAIVE)));
            user.put("naive2", cursor.getString(cursor.getColumnIndex(KEY_NAIVE2)));
            user.put("naive3", cursor.getString(cursor.getColumnIndex(KEY_NAIVE3)));
            userList.add(user);
        }
        return userList;
    }

    public ArrayList<HashMap<String, String>> GetUserByUserId(int userid){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String,String>> userList = new ArrayList<>();
        String query = "SELECT moving, moving2, moving3, smoothing, smoothing2, smoothing3, naive, naive2, naive3 FROM "+ TABLE_Users;
        Cursor cursor = db.query(TABLE_Users, new String[]{KEY_MOVING, KEY_MOVING2, KEY_MOVING3, KEY_SMOOTHING, KEY_SMOOTHING2, KEY_SMOOTHING3, KEY_NAIVE, KEY_NAIVE2, KEY_NAIVE3}, KEY_ID+ "=?", new String[]{String.valueOf(userid)}, null,null,null, null);
        if (cursor.moveToNext()){
            HashMap<String,String> user = new HashMap<>();
            user.put("moving", cursor.getString(cursor.getColumnIndex(KEY_MOVING)));
            user.put("moving2", cursor.getString(cursor.getColumnIndex(KEY_MOVING2)));
            user.put("moving3", cursor.getString(cursor.getColumnIndex(KEY_MOVING3)));
            user.put("smoothing", cursor.getString(cursor.getColumnIndex(KEY_SMOOTHING)));
            user.put("smoothing2", cursor.getString(cursor.getColumnIndex(KEY_SMOOTHING2)));
            user.put("smoothing3", cursor.getString(cursor.getColumnIndex(KEY_SMOOTHING3)));
            user.put("naive", cursor.getString(cursor.getColumnIndex(KEY_NAIVE)));
            user.put("naive2", cursor.getString(cursor.getColumnIndex(KEY_NAIVE2)));
            user.put("naive3", cursor.getString(cursor.getColumnIndex(KEY_NAIVE3)));
            userList.add(user);
        }
        return userList;
    }

    public void DeleteUser(int userid){
        SQLiteDatabase db = this.getWritableDatabase();
        List<Integer> database_ids = new ArrayList<Integer>();
        Cursor c = db.rawQuery("SELECT*FROM "+ TABLE_Users,null);
        while (c.moveToNext()) {
            database_ids.add(Integer.parseInt(c.getString(0)));
        }
        db.delete(TABLE_Users,KEY_ID + " =?", new String[]{String.valueOf(database_ids.get(userid))});
    }

    /**public void DeleteUser(int userid){
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try {
            db.delete(TABLE_Users, "KEY_ID=?", new String[]{String.valueOf(userid)});
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
        }**/
    /**public void DeleteUser(int userid){
        SQLiteDatabase db = this.getWritableDatabase();
        String updateQuery = "DELETE FROM " + TABLE_Users + " WHERE " + KEY_ID + "=" + "'" + userid + "'";
        Log.e("update sqlite ", updateQuery);
        db.execSQL(updateQuery);
        db.close();
    }**/

}
