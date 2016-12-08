package com.example.admin.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Admin on 12/8/2016.
 */

public class Mod_Student {
    Mydatabase mydatabase;
    public  Mod_Student(Context context){
        mydatabase = new Mydatabase(context);
    }
    public int insert(TB_Student student) {

        //Open connection to write data
        SQLiteDatabase db = mydatabase.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(student.KEY_name, student.name);
        values.put(student.KEY_lastname,student.lastname);
        values.put(student.KEY_nickname, student.nickname);

        // Inserting Row
        long student_Id = db.insert(student.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) student_Id;
    }

    public void delete(int student_Id) {

        SQLiteDatabase db = mydatabase.getWritableDatabase();
        // It's a good practice to use parameter ?, instead of concatenate string
        db.delete(TB_Student.TABLE, TB_Student.KEY_ID + "= ?", new String[] { String.valueOf(student_Id) });
        db.close(); // Closing database connection
    }

    public ArrayList<HashMap<String, String>> getStudentList() {
        //Open connection to read only
        SQLiteDatabase db = mydatabase.getReadableDatabase();
        String selectQuery =  "SELECT * FROM " + TB_Student.TABLE;

        //Student student = new Student();
        ArrayList<HashMap<String, String>> studentList = new ArrayList<>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> student = new HashMap<>();
                student.put(TB_Student.KEY_ID, cursor.getString(cursor.getColumnIndex(TB_Student.KEY_ID)));
                student.put(TB_Student.KEY_name, cursor.getString(cursor.getColumnIndex(TB_Student.KEY_name)));
                student.put(TB_Student.KEY_lastname, cursor.getString(cursor.getColumnIndex(TB_Student.KEY_lastname)));
                student.put(TB_Student.KEY_nickname, cursor.getString(cursor.getColumnIndex(TB_Student.KEY_nickname)));
                studentList.add(student);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return studentList;

    }
}
