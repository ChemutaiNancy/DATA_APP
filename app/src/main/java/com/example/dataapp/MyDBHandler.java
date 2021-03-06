package com.example.dataapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "products.db";
    private static final String TABLE_PRODUCTS = "products";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_PRODUCT_NAME = "product_name";

    public MyDBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_PRODUCTS + "(" + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_PRODUCT_NAME + "TEXT" + ")";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(sqLiteDatabase);
    }

    public void addProduct(Products products){
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCT_NAME, products.getProduct_name());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PRODUCTS, null, values);
        db.close();

    }

    public void deteleProduct(String productname){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + "TABLE_PRODUCTS" + "WHERE" + COLUMN_PRODUCT_NAME + "=\""+ productname + "\" ; ");
    }

    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_PRODUCTS + "WHERE 1";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        while(c.isAfterLast()){
            if (c.getString(c.getColumnIndex("product_name")) != null){
                dbString = c.getString(c.getColumnIndex("product_name"));
                dbString+="\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }
}
