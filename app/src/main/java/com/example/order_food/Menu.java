package com.example.order_food;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.order_food.Database.DBHelper;

public class Menu extends AppCompatActivity {

    TextView textView1;
    EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8;
     Button b1, button9, button2, button3, button4, button5;
     DBHelper db1;
     int no1, no2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        db1 = new DBHelper(getApplicationContext());

            //initialising components
        editText1 = findViewById(R.id.editTexthus2);
        editText2 = findViewById(R.id.editTexthus1);
        editText3 = findViewById(R.id.editTexthus3);
        editText4 = findViewById(R.id.editTexthus4);
        editText5 = findViewById(R.id.editTexthus5);
        editText6 = findViewById(R.id.editTexthus6);
        editText7 = findViewById(R.id.editTexthus7);
        editText8 = findViewById(R.id.editTexthus8);

        b1 = (Button) findViewById(R.id.button1);
        button9 =(Button) findViewById(R.id.buttonhusbtn1);
        button2 = findViewById(R.id.buttonhusbtn2);
        button3 = findViewById(R.id.buttonhusbtn3);
        button4 = findViewById(R.id.buttonhusbtn4);
        button5 = findViewById(R.id.button2);



    //navigate to payments
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Menu.this, Payments.class);
                startActivity(intent);
            }
        });

        addMenuDetails();
        addMenuDetails1();
        addMenuDetails2();
        addMenuDetails3();
        //viewmenuDetails();
    }
    //insert menu data to database
        public void addMenuDetails(){

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editText2.length() == 0) {
                    editText2.setError("Field cannot be empty");
                } else {
                    no1 = Integer.parseInt(editText1.getText().toString());

                    if (no1 > 20 || no1 < 1) {
                        Toast.makeText(Menu.this, "Number between 1-20", Toast.LENGTH_SHORT).show();
                    } else {

                        boolean isInserted = db1.addMenu(editText2.getText().toString(),
                                Integer.parseInt(editText1.getText().toString()));

                        if (isInserted = true) {
                            Toast.makeText(Menu.this, "Successfully added", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(Menu.this, "Not Added", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }}
            );

        }

    //insert menu data to database
    public void addMenuDetails1(){
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(editText3.length() == 0){
                    editText3.setError("Field cannot be empty");
                }else {
                    no2 = Integer.parseInt(editText4.getText().toString());

                    if (no1 > 20 || no1 < 1) {
                        Toast.makeText(Menu.this, "Number between 1-20", Toast.LENGTH_SHORT).show();
                    } else {
                        boolean isInserted = db1.addMenu(editText3.getText().toString(),
                                Integer.parseInt(editText4.getText().toString()));

                        if (isInserted = true) {
                            Toast.makeText(Menu.this, "Successfully added", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(Menu.this, "Not Added", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        }});
    }

    //insert menu data to database
    public void addMenuDetails2(){
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = db1.addMenu(editText5.getText().toString(),
                        Integer.parseInt(editText6.getText().toString()));

                if(isInserted = true){
                    Toast.makeText(Menu.this, "Successfully added", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Menu.this, "Not Added", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    //insert menu data to database
    public void addMenuDetails3(){
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = db1.addMenu(editText7.getText().toString(),
                        Integer.parseInt(editText8.getText().toString()));

                if(isInserted = true){
                    Toast.makeText(Menu.this, "Successfully added", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Menu.this, "Not Added", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    //retrieve database details to popup menu
    public void viewmenuDetails(View view)
    {

                Cursor men =  db1.getmenuDetails();

                if(men.getCount() == 0){
                    showmsg("Error", "no details found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();

                while (men.moveToNext()){
                    buffer.append("Menu ID: "+men.getString(0)+"\n");
                    buffer.append("Menu Type: "+men.getString(1)+"\n");
                    buffer.append("Quantity: "+men.getString(2)+"\n");

                    showmsg("Menu Details", buffer.toString());

                }

    }

    public void showmsg(String title,String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();
    }

//delete method

 /*   public void Deletemenus(){

        bDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer deletedRows = db.deletemenu(oid.getText().toString());

                if(deletedRows > 0)
                    Toast.makeText(adminPayments.this,"Item DELETED",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(adminPayments.this,"Item NOT DELETED",Toast.LENGTH_LONG).show();
            }
        });
    }*/




    }

    //end of menu java









