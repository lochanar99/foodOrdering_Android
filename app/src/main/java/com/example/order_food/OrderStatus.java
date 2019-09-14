package com.example.order_food;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.order_food.Database.DBHelper;

public class OrderStatus extends AppCompatActivity {

    DBHelper db;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_status);

        db = new DBHelper(this);

        b1 = findViewById(R.id.button11);

        /*viewAll();*/
    }

  /*  public void viewAll(){

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Cursor res =  db.getPaymentDetails();

               if(res.getCount()==0){

                   showMessage("Error","No data Found");

                   return;
               }

               StringBuffer buffer = new StringBuffer();

               while(res.moveToNext()){

                   buffer.append("oID"+res.getString(0)+"\n");
                   buffer.append("noItem"+res.getString(3)+"\n");
                   buffer.append("Total"+res.getString(5)+"\n");
               }

               showMessage("Data",buffer.toString());
            }
        });
    }*/

    public void showMessage(String title,String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();
    }

}
