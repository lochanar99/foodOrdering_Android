package Database;


import android.provider.BaseColumns;

public final class UsersMaster {
    private UsersMaster(){ }
    public static  class Users implements BaseColumns {
        public  static  final String TABLE_NAME_= "DeliveryEmp";
        public  static  final String COL_EmpID = "ID";
        public  static  final String COL_Fname = "FName";
        public  static  final String COL_Lname = "LName";
        public  static  final String COL_Vehino = "VehNO";
        public  static  final String COL_LicenNO = "LicenceNO";
        public  static  final String COL_PHONENO = "phoneNO";
        public  static  final String COL_EmpUserName= "UserName";
        public  static  final String COL_EmpPasswd= "PasseWord";



    }


}
