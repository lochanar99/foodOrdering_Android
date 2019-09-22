package com.example.order_food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.order_food.Database.DBHelper;

public class Menu extends AppCompatActivity {

    DBHelper db;
    TextView ItemName;
    EditText Qty;

    public Button b1, addcart1, addcart2, addcart3, addcart4, addcart5, addcart6, addcart7, addcart8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        db = new DBHelper(this);


        b1 = (Button)findViewById(R.id.button1);
        addcart1 = findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getPayment();
            }
        });

        AddMenuItems();
    }

    public void AddMenuItems(){
        addcart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = db.addMenu(ItemName.getText().toString(), Integer.parseInt(Qty.getText().toString()));


                if(isInserted = true)
                    Toast.makeText(Menu.this, "Added to Cart", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Menu.this, "Unsuccessful", Toast.LENGTH_SHORT).show();
            }
        });



    }





    //button3- ist add cart button id

    public void getPayment(){

        Intent intent = new Intent(this,Payments.class);

        startActivity(intent);
    }




    }


