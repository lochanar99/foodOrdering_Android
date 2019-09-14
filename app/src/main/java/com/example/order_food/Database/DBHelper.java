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
    public static final String col_92 = "Name";
    public static final String col_93 = "Address";
    public static final String col_94 = "noItem";
    public static final String col_95 = "Phone";
    public static final String col_96 = "Total";
    public static final String col_97 = "paymentM";



    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
       /* SQLiteDatabase db = this.getWritableDatabase(); */


    }

    @Override
    public void onCreate(SQLiteDatabase db) {


       db.execSQL("create table " + TABLE_NAME11 +"(oID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Address TEXT,noItem INTEGER,Phone INTEGER,TOTAL INTEGER,PaymentM TEXT)");
       /* db.execSQL("create table dileepa (id INTEGER PRIMARY KEY AUTOINCREMENT)"); */
        /*String SQL_CREATE_ENTRIES =
                "CREATE TABLE" + UsersMaster.Users.TABLE_NAME_+"("+UsersMaster.Users.TABLE_NAME_+"("+
                UsersMaster.Users.COL_EmpID+ "STRING PRIMAARY KEY,"+
                UsersMaster.Users.COL_Fname+ "TEXT," +
                UsersMaster.Users.COL_Lname+ "TEXT,"+
                UsersMaster.Users.COL_Vehino+ "TEXT,"+
                UsersMaster.Users.COL_LicenNO+ "TEXT,"+
                UsersMaster.Users.COL_EmpUserName+ "TEXT,"+
                UsersMaster.Users.COL_EmpPasswd+ "TEXT)";

        db.execSQL(SQL_CREATE_ENTRIES);*/


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVer, int newVer) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME11);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS dileepa");
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
}
