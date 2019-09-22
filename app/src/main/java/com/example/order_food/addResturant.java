package com.example.order_food;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.order_food.Database.DBHelper;

public class addResturant extends AppCompatActivity {

    DBHelper db;
    EditText ResName,ResBranch,ResAddress,TimeOpen,TimeClose;
    Button addRes,managePayment,viewR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_resturant);
        db = new DBHelper(this);

        viewR = findViewById(R.id.viewR);

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

        viewAll();


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

    public void viewAll(){


        viewR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor res =  db.getResDetails();

                if(res.getCount()==0){

                    showMessage("Error","No data Found");

                    return;
                }

                StringBuffer buffer = new StringBuffer();

                while(res.moveToNext()){

                    buffer.append("ORDER ID: "+res.getString(0)+"\n");
                    buffer.append("Restaurant Name: "+res.getString(1)+"\n");
                    buffer.append("Restaurant Branch: "+res.getString(2)+"\n");
                    buffer.append("Restaurant Address: "+res.getString(3)+"\n");
                    buffer.append("Open Time: "+res.getString(4)+"\n");
                    buffer.append("Open Time: "+res.getString(5)+"\n");
                }

                showMessage("Restaurant Details",buffer.toString());
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

}
