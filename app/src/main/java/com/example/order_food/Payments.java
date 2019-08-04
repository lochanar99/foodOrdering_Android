package com.example.order_food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Payments extends AppCompatActivity  {

    private ImageButton imageButtonx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);

        imageButtonx =findViewById(R.id.b1);

        imageButtonx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                redirectFeedback();
            }
        });
    }

    public void redirectFeedback(){
        Intent intent = new Intent(this, Feedback.class);

        startActivity(intent);
    }
}
