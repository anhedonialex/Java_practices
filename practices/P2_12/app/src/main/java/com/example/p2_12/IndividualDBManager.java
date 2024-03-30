package com.example.p2_12;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class IndividualDBManager {
    private SQLiteOpenHelper sqLiteHelper;

    public IndividualDBManager(SQLiteOpenHelper sqLiteOpenHelper) {
        this.sqLiteHelper = sqLiteOpenHelper;
    }
    public boolean saveTelephoneToDatabase(Telephone person){
        SQLiteDatabase db = this.sqLiteHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("model", person.getModel());
        cv.put("serial", person.getSerial());
        cv.put("price", person.getPrice());
        long rowId = db.insert("TABLE_TELEPHONES", null, cv);
        cv.clear();
        db.close();
        return rowId != -1;
    }
    public ArrayList<Telephone> loadAllTelephonesFromDatabase(){
        ArrayList<Telephone> telephones = new ArrayList<>();
        SQLiteDatabase db = this.sqLiteHelper.getWritableDatabase();
        Cursor dbCursor = db.query("TABLE_TELEPHONES",
                null,null,null,
                null,null,null);
        if(dbCursor.moveToFirst()){
            do{
                String fName = dbCursor.getString(dbCursor.getColumnIndexOrThrow("model"));
                String lName = dbCursor.getString(dbCursor.getColumnIndexOrThrow("serial"));
                int age = dbCursor.getInt(dbCursor.getColumnIndexOrThrow("price"));
                telephones.add(new Telephone(fName, lName, age));
            }while (dbCursor.moveToNext());
        }
        dbCursor.close();
        db.close();
        return telephones;
    }
}
