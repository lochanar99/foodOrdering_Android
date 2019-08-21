package com.example.order_food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Menu extends AppCompatActivity {


    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        b1 = (Button)findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getPayment();
            }
        });

    }

    public void getPayment(){

        Intent intent = new Intent(this,Payments.class);

        startActivity(intent);
    }




    }


