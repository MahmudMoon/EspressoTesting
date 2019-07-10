package com.example.moon.espressotesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

    public static final String TAG = "MyTag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        final ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Mustofa");
        arrayList.add("Mahmud");
        arrayList.add("Moon");
        arrayList.add("Mustofa");
        arrayList.add("Mahmud");
        arrayList.add("Moon");
        arrayList.add("Mustofa");
        arrayList.add("Mahmud");
        arrayList.add("Moon");
        arrayList.add("Mustofa");
        arrayList.add("Mahmud");
        arrayList.add("Moon");
        arrayList.add("Mustofa");
        arrayList.add("Mahmud");
        arrayList.add("Moon");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,arrayList);
        ((ListView)findViewById(R.id.list_one)).setAdapter(arrayAdapter);
        ((ListView)findViewById(R.id.list_one)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "onItemSelected: "+arrayList.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
