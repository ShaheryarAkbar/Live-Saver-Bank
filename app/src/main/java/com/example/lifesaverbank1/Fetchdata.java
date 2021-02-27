package com.example.lifesaverbank1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class Fetchdata extends AppCompatActivity {

    RecyclerView recyclerView;
    myadapter adapter;
    Cursor cursor;
    DBHelper DB;
    ArrayList<Model> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetchdata);

        recyclerView = findViewById(R.id.recview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DB = new DBHelper(this);

        /*cursor = new DBHelper(this).getdata();

//        while(cursor.moveToNext())
//        {
//            Model obj = new Model(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5));
//            dataholder.add(obj);
//        }
        adapter = new myadapter(dataholder);
        recyclerView.setAdapter(adapter);*/

        displayRowData();
    }

    private void displayRowData() {
        arrayList = new ArrayList<>(DB.getRowData());

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        myadapter adapter = new myadapter(getApplicationContext(), this, arrayList);
        recyclerView.setAdapter(adapter);
    }
}