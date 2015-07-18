package com.mycompany.sqliteandroidexample;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {


    DatabaseHelper database;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = new DatabaseHelper(this);
        //database is inserted every time you run this activity...
        // i mean new columns are added which were already there..duplicate columns...
        // or you need to clean the database..
        database.delete_all();
        database.setDatabase();
        cursor = database.select();
        cursor.moveToFirst();
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            System.out.println("**********************"+StudentTable._ID+" : "
                                                        +cursor.getString(0)+"***************************");
            System.out.println("**********************"+StudentTable.STUDENT_COLUMN_NAME+" : "
                                                        +cursor.getString(1)+"***************************");
            System.out.println("**********************"+StudentTable.CLASS_COLUMN_NAME+" : "
                                                        +cursor.getString(2)+"***************************");
            System.out.println("**********************"+StudentTable.MARKS_COLUMN_NAME+" : "
                                                        +cursor.getString(3)+"***************************");
            cursor.moveToNext();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
