package com.example.order_food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Payments extends AppCompatActivity {

    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);

        imageButton =(ImageButton) findViewById(R.id.b1);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Thankyou for Odering!",Toast.LENGTH_LONG);
                redirectFeedback();
            }
        });
    }

    public void redirectFeedback(){
        Intent intent = new Intent(this, Feedback.class);

        startActivity(intent);
    }
}
