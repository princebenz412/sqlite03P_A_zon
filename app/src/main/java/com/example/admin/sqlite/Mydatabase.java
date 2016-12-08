package com.example.admin.sqlite;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Admin on 12/8/2016.
 */

public class Mydatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "data_student.db";
    private static final int DATABASE_VERSION = 1;

    public Mydatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}