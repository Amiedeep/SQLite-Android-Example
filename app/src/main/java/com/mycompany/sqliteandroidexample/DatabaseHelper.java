package com.mycompany.sqliteandroidexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by amandeepsingh on 18/07/15.
 */
public class DatabaseHelper extends SQLiteOpenHelper {


    SQLiteDatabase database;

    public DatabaseHelper(Context context) {
        //bcoz i messed with database thats why upgraded version..
        super(context,"Student.db",null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(StudentTable.CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(StudentTable.DROP_TABLE_QUERY);
        onCreate(db);
    }

    public void setDatabase() {

        database = this.getWritableDatabase();

        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("Aman", "Graduate", 100));
        list.add(new Student("Ajit", "Nursery", 32));
        list.add(new Student("Arun", "PG", 90));
        list.add(new Student("Parmatma", "Undefined", 101));

        for(Student student: list) {
            ContentValues values = new ContentValues();
            values.put(StudentTable.STUDENT_COLUMN_NAME, student.name);
            values.put(StudentTable.CLASS_COLUMN_NAME, student.studentClass);
            values.put(StudentTable.MARKS_COLUMN_NAME, student.marks);

            long id= database.insert(StudentTable.TABLE_NAME, null, values);
            System.out.println();
        }
    }
//
//    public void insert() {
//
//    }
//
//    public void delete() {
//
//    }

    public Cursor select() {

        database = this.getReadableDatabase();
//        return database.execSQL("SELECT * FROM "+StudentTable.TABLE_NAME);
        return database.rawQuery("SELECT * FROM Student", null);
    }

    public void delete_all() {
        database = this.getWritableDatabase();
//        database.rawQuery(StudentTable.DELETE_ALL_ROWS_QUERY, null);
        database.delete(StudentTable.TABLE_NAME, null, null);
    }
}
