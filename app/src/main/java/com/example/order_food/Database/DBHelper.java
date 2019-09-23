package com.example.order_food.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.os.Build.ID;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "OnlineFood.db";
    public static final String TABLE_NAME11 = "payment_table";
    public static final String col_91 = "oID";
    public static final String col_92 = "Name";
    public static final String col_93 = "Address";
    public static final String col_94 = "noItem";
    public static final String col_95 = "Phone";
    public static final String col_96 = "Total";
    public static final String col_97 = "paymentM";

    public static final String TABLE_NAME13 = "Resturant_Manager";
    public static final String col_1 = "ResID";
    public static final String col_2 = "ResName";
    public static final String col_3 = "ResBranch";
    public static final String col_4 = "ResAddress";
    public static final String col_5 = "TimeOpen";
    public static final String col_6 = "TimeClose";


    public static final String TABLE_NAME14 = "Menu_table";
    public static final String col_10 = "ID";
    public static final String col_11 = "ItemName";
    public static final String col_12 = "Qty";



    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
       /* SQLiteDatabase db = this.getWritableDatabase(); */
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Creating the tables in the database


       db.execSQL("create table " + TABLE_NAME11 +"(oID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Address TEXT,noItem INTEGER,Phone INTEGER,TOTAL INTEGER,PaymentM TEXT)");
        db.execSQL("create Table " + TABLE_NAME13 + "(ResID INTEGER PRIMARY KEY AUTOINCREMENT, ResName TEXT, ResBranch TEXT, ResAddress TEXT, TimeOpen DATETIME, TimeClose DATETIME)");
        db.execSQL("create table " + TABLE_NAME14 + "(mID INTEGER PRIMARY KEY AUTOINCREMENT, ItemName TEXT, Qty INTEGER)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVer, int newVer) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME11);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME13);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME14);
        onCreate(sqLiteDatabase);

    }

    public boolean addPaymentDetails(String name, String address,Integer noItem,Integer phone,Integer total, String paymentM){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(col_92,name);
        contentValues.put(col_93,address);
        contentValues.put(col_94,noItem);
        contentValues.put(col_95,phone);
        contentValues.put(col_96,total);
        contentValues.put(col_97,paymentM);

        long result = db.insert(TABLE_NAME11,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getPaymentDetails(){
        SQLiteDatabase db = this.getWritableDatabase ();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME11,null);
        return res;
    }
    public Cursor getResDetails(){
        SQLiteDatabase db = this.getWritableDatabase ();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME13,null);
        return res;
    }

    public boolean addRes(String ResName, String ResBranch,String ResAddress,String TimeOpen,String TimeClose){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(col_2,ResName);
        contentValues.put(col_3,ResBranch);
        contentValues.put(col_4,ResAddress);
        contentValues.put(col_5,TimeOpen);
        contentValues.put(col_6,TimeClose);

        long result = db.insert(TABLE_NAME13,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean updatePayment(String oId,String name, String address,Integer noItem,Integer phone,Integer total, String paymentM){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(col_91,oId);
        contentValues.put(col_92,name);
        contentValues.put(col_93,address);
        contentValues.put(col_94,noItem);
        contentValues.put(col_95,phone);
        contentValues.put(col_96,total);
        contentValues.put(col_97,paymentM);

        db.update(""+TABLE_NAME11,contentValues,"oID = ?",new String[]{oId});

        return true;

    }

    public Integer deletePayment(String oId){

        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(TABLE_NAME11,"oID = ?",new String[] {oId});
    }

    //Restaurant manager..............(Update)
    public boolean updateResDetails(String Rid,String ResName, String ResBranch,String ResAddress,String TimeOpen,String TimeClose){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1,Rid);
        contentValues.put(col_2,ResName);
        contentValues.put(col_3,ResBranch);
        contentValues.put(col_4,ResAddress);
        contentValues.put(col_5,TimeOpen);
        contentValues.put(col_6,TimeClose);

        db.update(""+TABLE_NAME13,contentValues,"ResID = ?",new String[]{Rid});

        return true;

    }
    //Restaurant manager.............(delete)
    public Integer deleteRestaurant(String Rid){

        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(TABLE_NAME13,"ResID = ?",new String[] {Rid});
    }


    public boolean addMenu(String ItemName, Integer Qty){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(col_11,ItemName);
        contentValues.put(col_12,Qty);

        long result = db.insert(TABLE_NAME14, null, contentValues);

        if(result == -1)
            return false;
        else
            return true;
    }

  public Cursor getmenuDetails()
  {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor men = db.rawQuery("select * from " +TABLE_NAME14, null);
        return men;
    }


  //menu delete method in dbhelper

   /* public Integer deleteMenu(String ID){
        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(TABLE_NAME14, "ID = ?", new String[] {ID});
    }*/

}
