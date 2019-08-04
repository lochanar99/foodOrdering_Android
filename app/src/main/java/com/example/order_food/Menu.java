package com.example.order_food;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class Menu extends AppCompatActivity implements View.OnClickListener{

    private RadioButton radioButton8, radioButton9, radioButton10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        radioButton8 = findViewById(R.id.radioButton8);
        radioButton8.setOnClickListener(this);
        radioButton9 = findViewById(R.id.radioButton9);
        radioButton9.setOnClickListener(this);
        radioButton10 = findViewById(R.id.radioButton10);
        radioButton10.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.radioButton8:
                if(radioButton8.isSelected()){
                    radioButton8.setSelected(false);
                    radioButton8.setSelected(true);
                }else{
                    radioButton8.setSelected(true);
                    radioButton8.setSelected(true);
                }
                break;
        }

        switch (view.getId()){
            case R.id.radioButton9:
                if(radioButton9.isSelected()){
                    radioButton9.setSelected(false);
                    radioButton9.setSelected(true);
                }else{
                    radioButton9.setSelected(true);
                    radioButton9.setSelected(true);
                }
                break;
        }



    }
}
