package com.example.den.ggg;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDataBase mydb = new MyDataBase(this);
        SQLiteDatabase sqdb = mydb.getWritableDatabase();

        String insertQuerty = "";
        sqdb.execSQL(insertQuerty);

        String query = "SELECT " + MyDataBase.UID + ", " + MyDataBase.ТАВLЕ_NАМЕ;
        Cursor cursor2 = sqdb.rawQuery(query, null);

        while (cursor2.moveToNext()) {
            @SuppressLint("Range") int id = cursor2.getInt(cursor2.getColumnIndex(MyDataBase.UID));
            @SuppressLint("Range") String name = cursor2.getString(cursor2.getColumnIndex(MyDataBase.UNAМE));
            Log.i("LOG_TAG", "ROW " + id + "НАS UNAМE" + name);
            cursor2.close();

            sqdb.close();
            mydb.close();
        }
    }
}