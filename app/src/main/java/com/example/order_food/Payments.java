package com.example.order_food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


import com.example.order_food.Database.DBHelper;

public class Payments extends AppCompatActivity  {

    private ImageButton imageButtonx;
    private Button bbb;
    DBHelper db;
    EditText eName,eAddress,eNoOfItem,ePhone,eTotal,ePaymentM;
    Button bSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);

        eName = findViewById(R.id.e1);
        eAddress = findViewById(R.id.e2);
        eNoOfItem = findViewById(R.id.e3);
        ePhone = findViewById(R.id.e4);
        eTotal = findViewById(R.id.e5);
        ePaymentM = findViewById(R.id.e6);

        bSubmit = findViewById(R.id.button12);

        db = new DBHelper(this);

        imageButtonx =findViewById(R.id.bb1);

        imageButtonx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                redirectFeedback();
            }
        });

        bbb =findViewById(R.id.b3);

        bbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                redirectOrderStatus();
            }
        });

        addPayment();
    }

    public void addPayment(){

        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = db.addPaymentDetails(eName.getText().toString(),
                                     eAddress.getText().toString(),
                                    Integer.parseInt(eNoOfItem.getText().toString()),
                                    Integer.parseInt(ePhone.getText().toString()),
                                    Integer.parseInt(eTotal.getText().toString()),
                                    ePaymentM.getText().toString() );

                    if(isInserted = true)
                        Toast.makeText(Payments.this,"Order Successfully Submitted",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(Payments.this,"Failed to Submit Order",Toast.LENGTH_LONG).show();

            }
        });
    }

    public void redirectFeedback(){
        Intent intent = new Intent(this, Feedback.class);


        startActivity(intent);
        Toast.makeText(getApplicationContext(),"THANKYOU FOR ORDERING",Toast.LENGTH_LONG);
    }

    public void redirectOrderStatus(){

        Intent intent= new Intent(this,OrderStatus.class);

        startActivity(intent);

    }
}
