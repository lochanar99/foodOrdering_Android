package com.example.order_food;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.order_food.Database.DBHelper;

public class adminPayments extends AppCompatActivity {

    DBHelper db;
    Button bViewOrder,bUpdate,bDelete;
    EditText oid,ename,eaddress,eNoofItems,ePhone,eTotal,ePaymentMethod;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_payments);

        //Casting the buttons and making an object from the database

        bViewOrder = findViewById(R.id.button16);
        bUpdate = findViewById(R.id.button18);

        db = new DBHelper(this);

        oid = findViewById(R.id.editText_1);
        ename= findViewById(R.id.editText_2);
        eaddress = findViewById(R.id.editText_3);
        eNoofItems = findViewById(R.id.editText_4);
        ePhone = findViewById(R.id.editText_5);
        eTotal = findViewById(R.id.editText_6);
        ePaymentMethod = findViewById(R.id.editText_7);

        bDelete = findViewById(R.id.button15);



        viewAll();

        updatePaymentDetails();

        DeletePayment();
    }

    //Function to retrieve data from the database into a popup screen
    public void viewAll(){

        bViewOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor res =  db.getPaymentDetails();

                if(res.getCount()==0){

                    showMessage("Error","No data Found");

                    return;
                }

                StringBuffer buffer = new StringBuffer();

                while(res.moveToNext()){

                    buffer.append("ORDER ID: "+res.getString(0)+"\n");
                    buffer.append("Customer Name: "+res.getString(1)+"\n");
                    buffer.append("Customer Address: "+res.getString(2)+"\n");
                    buffer.append("NO. of Items: "+res.getInt(3)+"\n");
                    buffer.append("Customer Num: "+res.getInt(4)+"\n");
                    buffer.append("TOTAL: "+res.getInt(5)+"\n");
                    buffer.append("Payment Method: "+res.getString(6)+"\n==============================\n");
                }

                showMessage("Saved Payments",buffer.toString());
            }
        });
    }

    //The popup message alert dialog
    public void showMessage(String title,String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();
    }
    //Function to update the payment details
    public void updatePaymentDetails(){

        bUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phoneNum = "[0-9]{10}";
                String payCash = "CASH";
                String payCard = "CARD";
                String payCash1="cash";
                String paycard1 = "card";


                //Validation for the onclick button event

                if(ename.getText().toString().isEmpty()== true){
                    ename.setError("Please enter the customer NAME");
                }
                else if(eaddress.getText().toString().isEmpty()==true){
                    eaddress.setError("Please enter the address");
                }
                else if(eNoofItems.getText().toString().isEmpty()==true){
                    eNoofItems.setError("Enter the number of items ordered by customer!");
                }
                else if(ePhone.getText().toString().isEmpty()==true){
                    ePhone.setError("Please enter your phone number");
                }
                else if(!ePhone.getText().toString().matches(phoneNum)){
                    ePhone.setError("Please enter 10 digits to the phone number");
                }
                else if(eTotal.getText().toString().isEmpty()==true){
                    eTotal.setError("Please enter the customers total manually");
                }
                else if(ePaymentMethod.getText().toString().isEmpty()==true){
                    ePaymentMethod.setError("Please enter the payment method of the customer");
                }
                else {

                    boolean isUpdate = db.updatePayment(oid.getText().toString(), ename.getText().toString(), eaddress.getText().toString(), Integer.parseInt(eNoofItems.getText().toString()), Integer.parseInt(ePhone.getText().toString()), Integer.parseInt(eTotal.getText().toString()), ePaymentMethod.getText().toString());

                    if (isUpdate == true)
                        Toast.makeText(adminPayments.this, "Successfully Updated the PAYMENT", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(adminPayments.this, "Unsuccessful in updating payment", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
    //Function to delete a payment
    public void DeletePayment(){

        bDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer deletedRows = db.deletePayment(oid.getText().toString());

                if(deletedRows > 0)
                    Toast.makeText(adminPayments.this,"PAYMENT DELETED",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(adminPayments.this,"PAYMENT NOT DELETED",Toast.LENGTH_LONG).show();
            }
        });
    }
}
