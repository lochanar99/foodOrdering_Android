package com.example.order_food;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.order_food.Database.DBHelper;

public class addResturant extends AppCompatActivity {

    DBHelper db;
    EditText Rid,ResName,ResBranch,ResAddress,TimeOpen,TimeClose;
    Button addRes,managePayment,viewR,Rupdate,Rdelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_resturant);
        db = new DBHelper(this);

        viewR = findViewById(R.id.viewR);

        Rid = findViewById(R.id.editText350);
        ResName = findViewById(R.id.ResName);
        ResBranch = findViewById(R.id.ResBranch);
        ResAddress = findViewById(R.id.ResAddress);
        TimeOpen = findViewById(R.id.TimeOpen);
        TimeClose = findViewById(R.id.TimeClose);
        addRes = (Button) findViewById(R.id.addRes);
        Rupdate = findViewById(R.id.Rupdate);
        Rdelete = findViewById(R.id.Rdelete);


        managePayment = findViewById(R.id.button17);
        //View = (Button) findViewById(R.id.View);
        //delete = findViewById(R.id.delete);
        //ListView = findViewById(R.id.ListView);



        insertRes();

        viewAll();
        updateResDetails();

        DeleteRestaurant();


        //LOCHANA(ADMIN PAYMENT PAGE NAVIGATION)
        managePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(addResturant.this,adminPayments.class);
                startActivity(intent);
            }
        });
    }

    //Restaurant details insert..................
    public void insertRes(){

        addRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ResName.getText().toString().isEmpty()== true){
                    ResName.setError("Please enter the restaurant NAME");
                }
                else if(ResBranch.getText().toString().isEmpty()==true){
                    ResBranch.setError("Please enter the branch");
                }
                else if(ResAddress.getText().toString().isEmpty()==true){
                    ResAddress.setError("Enter the restaurant address!");
                }
                else if(TimeOpen.getText().toString().isEmpty()==true){
                    TimeOpen.setError("Please enter open time of the restaurant ");
                }
                else if(TimeClose.getText().toString().isEmpty()==true){
                    TimeClose.setError("Please enter closing time of the restaurant");
                }
                else {
                    boolean isInserted = db.addRes(ResName.getText().toString(), ResBranch.getText().toString(), ResAddress.getText().toString(),
                            TimeOpen.getText().toString(), TimeClose.getText().toString());

                    if (isInserted = true)
                        Toast.makeText(addResturant.this, "Successfully Submitted", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(addResturant.this, "Failed to Submit Order", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void viewAll(){


        viewR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor res =  db.getResDetails();

                if(res.getCount()==0){

                    showMessage("Error","No data Found");

                    return;
                }

                StringBuffer buffer = new StringBuffer();

                while(res.moveToNext()){

                    buffer.append("ORDER ID: "+res.getString(0)+"\n");
                    buffer.append("Restaurant Name: "+res.getString(1)+"\n");
                    buffer.append("Restaurant Branch: "+res.getString(2)+"\n");
                    buffer.append("Restaurant Address: "+res.getString(3)+"\n");
                    buffer.append("Open Time: "+res.getString(4)+"\n");
                    buffer.append("Open Time: "+res.getString(5)+"\n==============================\n");
                }

                showMessage("Saved Restaurant Details",buffer.toString());
            }
        });
    }
    //code for the pop-up message
    public void showMessage(String title,String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();
    }
    //update restaurant details.............................
    public void updateResDetails(){

        Rupdate.setOnClickListener(new View.OnClickListener() {
            @Override

            //validation for the Restaurant details.............
            public void onClick(View view) {

                if(ResName.getText().toString().isEmpty()== true){
                    ResName.setError("Please enter the restaurant NAME");
                }
                else if(ResBranch.getText().toString().isEmpty()==true){
                    ResBranch.setError("Please enter the branch");
                }
                else if(ResAddress.getText().toString().isEmpty()==true){
                    ResAddress.setError("Enter the restaurant address!");
                }
                else if(TimeOpen.getText().toString().isEmpty()==true){
                    TimeOpen.setError("Please enter open time of the restaurant ");
                }
                else if(TimeClose.getText().toString().isEmpty()==true){
                    TimeClose.setError("Please enter closing time of the restaurant");
                }
                else {

                    boolean isUpdate = db.updateResDetails(Rid.getText().toString(), ResName.getText().toString(), ResBranch.getText().toString(),ResAddress.getText().toString(), TimeOpen.getText().toString(), TimeClose.getText().toString());

                    if (isUpdate == true)
                        Toast.makeText(addResturant.this, "Successfully Updated the RESTAURANT DETAILS", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(addResturant.this, "Unsuccessful in updating RESTAURANT DETAILS", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
    //delete restaurant details.........................................
    public void DeleteRestaurant(){

        Rdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer deletedRows = db.deleteRestaurant(Rid.getText().toString());

                if(deletedRows > 0)
                    Toast.makeText(addResturant.this,"DETAILS DELETED",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(addResturant.this,"DETAILS NOT DELETED",Toast.LENGTH_LONG).show();
            }
        });
    }

}
