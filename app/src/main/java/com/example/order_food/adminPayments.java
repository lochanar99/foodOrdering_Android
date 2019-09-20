package com.example.order_food;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.order_food.Database.DBHelper;

public class adminPayments extends AppCompatActivity {

    DBHelper db;
    Button bViewOrder,bUpdate;
    EditText oid,ename,eaddress,eNoofItems,ePhone,eTotal,ePaymentMethod;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_payments);

        bViewOrder = findViewById(R.id.button16);
        bUpdate = findViewById(R.id.button18);

        db = new DBHelper(this);

        oid = findViewById(R.id.editText_1);
        ename= findViewById(R.id.editText_2);
        eaddress = findViewById(R.id.editText_3);
        eNoofItems = findViewById(R.id.editText_4);
        ePhone = findViewById(R.id.editText_5);
        eTotal = findViewById(R.id.editText_6);
        ePaymentMethod = findViewById(R.id.editText_7);



        viewAll();

        updatePaymentDetails();
    }


    public void viewAll(){

        bViewOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor res =  db.getPaymentDetails();

                if(res.getCount()==0){

                    showMessage("Error","No data Found");

                    return;
                }

                StringBuffer buffer = new StringBuffer();

                while(res.moveToNext()){

                    buffer.append("ORDER ID: "+res.getString(0)+"\n");
                    buffer.append("Customer Name:"+res.getString(1)+"\n");
                    buffer.append("Customer Address:"+res.getString(2)+"\n");
                    buffer.append("NO. of Items: "+res.getInt(3)+"\n");
                    buffer.append("Customer Num:"+res.getInt(4)+"\n");
                    buffer.append("TOTAL: "+res.getInt(5)+"\n");
                    buffer.append("Payment Method"+res.getString(6)+"\n");
                }

                showMessage("Saved Payments",buffer.toString());
            }
        });
    }

    public void showMessage(String title,String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();
    }

    public void updatePaymentDetails(){

        bUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isUpdate = db.updatePayment(oid.getText().toString(),ename.getText().toString(),eaddress.getText().toString(),Integer.parseInt(eNoofItems.getText().toString()),Integer.parseInt(ePhone.getText().toString()),Integer.parseInt(eTotal.getText().toString()),ePaymentMethod.getText().toString());

                if(isUpdate == true)
                    Toast.makeText(adminPayments.this,"DATA INSERTED",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(adminPayments.this,"DATA NOT INSERTED",Toast.LENGTH_LONG).show();


            }
        });
    }
}
