package com.example.order_food;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.order_food.Database.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class displayRes extends AppCompatActivity {
    /*DBHelper dbhelper;
    ListView list;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.res_details);

        list = findViewById(R.id.list);

        dbhelper = new DBHelper(this);

        final List<User> dataset = dbhelper.readAllInfo();

        List<String> data = new ArrayList<>();

        for(User U : dataset){

            String txt = "User Name : " + U.getUn() + " Password : " + U.getPwd();
            data.add(txt);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1,data);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getApplicationContext(),dataset.get(i).getUn(),Toast.LENGTH_LONG).show();

            }
        });

*/

    }
}
