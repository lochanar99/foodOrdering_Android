package com.example.order_food;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


import com.example.order_food.Database.DBHelper;

public class Payments extends AppCompatActivity  {



    DBHelper db;
    EditText eName,eAddress,eNoOfItem,ePhone,eTotal,ePaymentM;
    Button bSubmit,bfeedback;
   // Button bSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);

        //Casting the buttons.

        eName = findViewById(R.id.e1);
        eAddress = findViewById(R.id.e2);
        eNoOfItem = findViewById(R.id.e3);
        ePhone = findViewById(R.id.e4);
        eTotal = findViewById(R.id.e5);
        ePaymentM = findViewById(R.id.e6);

        bSubmit = findViewById(R.id.button12);

       // bSummary = findViewById(R.id.button13);

        //Making the db object

        db = new DBHelper(this);

        bfeedback =findViewById(R.id.button6);

        bfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                redirectFeedback();
                Toast.makeText(getApplicationContext(),"THANKYOU FOR ORDERING",Toast.LENGTH_LONG).show();

            }
        });



        addPayment();

       // viewAll();
    }

    //Fuction to add payment
    public void addPayment(){

        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    String phoneNum = "[0-9]{10}";
                    String payCash = "CASH";
                    String payCard = "CARD";
                    String payCash1="cash";
                    String paycard1 = "card";

                    //Validation when inserting data into the database


                    if(eName.getText().toString().isEmpty()== true){
                        eName.setError("Please enter the customer NAME");
                    }
                    else if(eAddress.getText().toString().isEmpty()==true){
                        eAddress.setError("Please enter the address");
                    }
                    else if(eNoOfItem.getText().toString().isEmpty()==true){
                        eNoOfItem.setError("Enter the number of items ordered by customer!");
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
                    else if(ePaymentM.getText().toString().isEmpty()==true){
                        ePaymentM.setError("Please enter the payment method of the customer");
                    }
                    /*else if(ePaymentM.getText().toString().matches(payCard)){
                        ePaymentM.setError("Incorrect payment method");
                    }
                    else if(!ePaymentM.getText().toString().matches(payCash)){
                        ePaymentM.setError("Incorrect payment method");
                    }
                    else if(!ePaymentM.getText().toString().matches(payCash1)){
                        ePaymentM.setError("Incorrect payment method");
                    }
                    else if(!ePaymentM.getText().toString().matches(paycard1)){
                        ePaymentM.setError("Incorrect payment method");
                    }*/
                    else {
                        boolean isInserted = db.addPaymentDetails(eName.getText().toString(),
                                eAddress.getText().toString(),
                                Integer.parseInt(eNoOfItem.getText().toString()),
                                Integer.parseInt(ePhone.getText().toString()),
                                Integer.parseInt(eTotal.getText().toString()),
                                ePaymentM.getText().toString());

                        if (isInserted = true)
                            Toast.makeText(Payments.this, "Order Successfully Submitted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Payments.this, "Failed to Submit Order", Toast.LENGTH_LONG).show();


                    }
            }
        });
    }

        //Fucntion to go to the feedback page interface

    public void redirectFeedback() {
        Intent intent = new Intent(Payments.this, Feedback.class);


        startActivity(intent);

    }}

  /* public void redirectOrderStatus(){

        Intent intent= new Intent(this,OrderStatus.class);

        startActivity(intent);

    }*/

   /* public void viewAll(){

        bSummary.setOnClickListener(new View.OnClickListener() {
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
                    buffer.append("NO. of Items: "+res.getInt(3)+"\n");
                    buffer.append("TOTAL: "+res.getInt(5)+"\n\n");
                }

                showMessage("Data",buffer.toString());
            }
        });
    }

    public void showMessage(String title,String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();
    }

    public void validation(){

        boolean isValid = true;
        if(eName.getText().toString().isEmpty()){



        }
    }
}
*/