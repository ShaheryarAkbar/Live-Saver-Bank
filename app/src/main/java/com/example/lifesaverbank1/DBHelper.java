package com.example.lifesaverbank1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table userdetails(name TEXT primary key, fname TEXT, contact TEXT, address TEXT, bgroup TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        DB.execSQL("drop Table if exists Userdetails");
    }

    public Boolean insertuserdata(String name, String fname, String contact, String address, String bgroup)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("fname", fname);
        contentValues.put("contact", contact);
        contentValues.put("address", address);
        contentValues.put("bgroup", bgroup);
        long result = DB.insert("Userdetails", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean updateuserdata(String name, String fname, String contact, String address, String bgroup)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fname", fname);
        contentValues.put("contact", contact);
        contentValues.put("address", address);
        contentValues.put("bgroup", bgroup);
        Cursor cursor  = DB.rawQuery("select * from Userdetails where name = ?", new String[]{name});
        if(cursor.getCount()>0) {

            long result = DB.update("Userdetails", contentValues, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else {
            return false;
        }
    }

    public Boolean deleteuserdata(String name)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor  = DB.rawQuery("select * from Userdetails where name = ?", new String[]{name});
        if(cursor.getCount()>0) {

            long result = DB.delete("Userdetails", "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else {
            return false;
        }
    }

    public ArrayList<Model> getRowData() {
        ArrayList<Model> arrayList = new ArrayList<>();
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("SELECT * FROM Userdetails", null );

        if(cursor.moveToFirst()) {
            do {
                Model model = new Model();
                model.setName(cursor.getString(0));
                model.setFname(cursor.getString(1));
                model.setContact(cursor.getString(2));
                model.setAddress(cursor.getString(3));
                model.setBgroup(cursor.getString(4));
                arrayList.add(model);

            }
            while (cursor.moveToNext());
        }
        return arrayList;
    }

    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails", null);
        return cursor;
    }
}
