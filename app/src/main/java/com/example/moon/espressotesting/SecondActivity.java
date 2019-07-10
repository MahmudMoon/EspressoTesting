package com.example.moon.espressotesting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
     String input = "test";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final TextView viewById = (TextView) findViewById(R.id.resultView);
        Bundle inputData = getIntent().getExtras();
        if(inputData!=null)
         input = inputData.getString("input");
        viewById.setText(input);
        ((Button)findViewById(R.id.btn_make_double)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+=input;
                viewById.setText(input);

                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
}
