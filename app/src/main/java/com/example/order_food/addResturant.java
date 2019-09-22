package com.example.order_food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.order_food.Database.DBHelper;

public class addResturant extends AppCompatActivity {

    DBHelper db;
    EditText ResName,ResBranch,ResAddress,TimeOpen,TimeClose;
    Button addRes,managePayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_resturant);
        db = new DBHelper(this);

        ResName = findViewById(R.id.ResName);
        ResBranch = findViewById(R.id.ResBranch);
        ResAddress = findViewById(R.id.ResAddress);
        TimeOpen = findViewById(R.id.TimeOpen);
        TimeClose = findViewById(R.id.TimeClose);
        addRes = (Button) findViewById(R.id.addRes);

        managePayment = findViewById(R.id.button17);
        //View = (Button) findViewById(R.id.View);
        //delete = findViewById(R.id.delete);
        //ListView = findViewById(R.id.ListView);
        insertRes();


        //LOCHANA(ADMIN PAYMENT PAGE NAVIGATION)
        managePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(addResturant.this,adminPayments.class);
                startActivity(intent);
            }
        });
    }
    public void insertRes(){

        addRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = db.addRes(ResName.getText().toString(), ResBranch.getText().toString(), ResAddress.getText().toString(),
                        TimeOpen.getText().toString(), TimeClose.getText().toString());

                if(isInserted = true)
                    Toast.makeText(addResturant.this,"Order Successfully Submitted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(addResturant.this,"Failed to Submit Order",Toast.LENGTH_LONG).show();

            }
        });
    }

    public void displayRestaurants(View view){

        startActivity(new Intent(this,displayRes.class));
    }


}
