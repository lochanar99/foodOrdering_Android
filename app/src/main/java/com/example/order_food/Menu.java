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
    EditText editText1, editText2;
     Button b1, button9, button2;
     DBHelper db1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        editText1 = findViewById(R.id.editTexthus2);
        editText2 = findViewById(R.id.editTexthus1);
        b1 = (Button) findViewById(R.id.button1);
        button9 =(Button) findViewById(R.id.buttonhusbtn1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Menu.this, Payments.class);
                startActivity(intent);
            }
        });

        addMenuDetails();
        //viewmenuDetails();
    }

        public void addMenuDetails(){

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = db1.addMenu(editText2.getText().toString(),
                        Integer.parseInt(editText1.getText().toString()));

                if(isInserted = true){
                    Toast.makeText(Menu.this, "Successfully added", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Menu.this, "Not Added", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

   /* public void viewmenuDetails(){
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        });
    }

    public void showmsg(String title,String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();
    }
*/

    }









