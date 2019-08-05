package com.example.order_food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Payments extends AppCompatActivity  {

    private ImageButton imageButtonx;
    private Button bbb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);

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
    }

    public void redirectFeedback(){
        Intent intent = new Intent(this, Feedback.class);

        Toast.makeText(getApplicationContext(),"THANKYOU FOR ORDERING",Toast.LENGTH_LONG);
        startActivity(intent);

    }

    public void redirectOrderStatus(){

        Intent intent= new Intent(this,OrderStatus.class);

        startActivity(intent);

    }
}
