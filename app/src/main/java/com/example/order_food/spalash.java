package com.example.order_food;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class spalash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalash);

        //Removing Action Bar

      //  getSupportActionBar().hide();

        new Handler() .postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(spalash.this,MainActivity.class);

                startActivity(intent);

                finish();
            }
        }, 3000);
    }
}
