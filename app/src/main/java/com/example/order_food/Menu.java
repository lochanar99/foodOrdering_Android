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

    TextView textView1;
    EditText editText1, editText2;
     Button b1, button9;
     DBHelper db1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        editText1 = findViewById(R.id.editTexthus2);
        editText2 = findViewById(R.id.editTexthus1);
        b1 = (Button) findViewById(R.id.button1);
        button9 = findViewById(R.id.buttonhusbtn1);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Menu.this, Payments.class);
                startActivity(intent);
            }


        });

        adddMenuDetails();

    }

        public void adddMenuDetails(){

            button9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isInserted = db1.addMenu(editText2.getText().toString(),
                            Integer.parseInt(editText1.getText().toString()));

                    if (isInserted = true) {
                        Toast.makeText(Menu.this, "Successfully added", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Menu.this, "Not Added", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }










