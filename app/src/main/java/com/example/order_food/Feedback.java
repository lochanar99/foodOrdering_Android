package com.example.order_food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Feedback extends AppCompatActivity {

    //Button badmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);


        /*
        final EditText edit1 = (EditText)findViewById(R.id.editText);
        final EditText edit2 = (EditText)findViewById(R.id.editText2);
        Button btn=(Button) findViewById(R.id.button);
        btn.setOnClickListener (new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/html");
        i.putExtra(Intent.EXTRA_EMAIL,new String(original,"xyz@gmail.com"));
        i.putExtra(Intent.EXTRA_SUBJECT,value,"Feedback From App");
        i.putExtra(Intent.EXTRA_TEXT,value,"Name:"+edit1.getText()+"\n Message:"+edit2.getText());
        try{
        startActivity(Intent.createChooser(i,title,"Please select Email"));
        }
        catch(android.content.ActivityNotFoundException ex)
        {
        Toast.makeText(context.MainActivity.this, text,"There are no Email Clients" , Toast.LENGTH_SHORT).show();
        }
        }
        }}
        };

        }
        */


    }
}


