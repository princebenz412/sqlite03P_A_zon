package com.example.admin.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ListStudent extends AppCompatActivity {

    Mod_Student mod_student;
    ListView setListAdapter;
    ArrayList<HashMap<String, String>> data_student;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_student);



        mod_student = new Mod_Student(this);
        setListAdapter = (ListView) findViewById(R.id.ListView);
        data_student = mod_student.getStudentList();
        ListAdapter adapter = new SimpleAdapter(getApplicationContext()
                , data_student
                , R.layout.custom_list
                , new String[]{TB_Student.KEY_name, TB_Student.KEY_lastname, TB_Student.KEY_nickname}
                , new int[]{R.id.listname, R.id.listlastname, R.id.listnickname});
        setListAdapter.setAdapter(adapter);
    }
}
