import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import Database.UsersMaster;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "FootDelivery.db";

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES =
                "CREATE TABLE" + UsersMaster.Users.TABLE_NAME_+"("+UsersMaster.Users.TABLE_NAME_+"("+
                UsersMaster.Users.COL_EmpID+ "STRING PRIMAARY KEY,"+
                UsersMaster.Users.COL_Fname+ "TEXT," +
                UsersMaster.Users.COL_Lname+ "TEXT,"+
                UsersMaster.Users.COL_Vehino+ "TEXT,"+
                UsersMaster.Users.COL_LicenNO+ "TEXT,"+
                UsersMaster.Users.COL_EmpUserName+ "TEXT,"+
                UsersMaster.Users.COL_EmpPasswd+ "TEXT)";

        db.execSQL(SQL_CREATE_ENTRIES);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVer, int newVer) {

    }
}
