package com.example.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView tv=findViewById(R.id.txt1);
        TextView tw=findViewById(R.id.textView3);

        Bundle bund=getIntent().getExtras();
        tv.setText(bund.getString("name"));
        tw.setText("" +bund.getInt("year"));


    }
}
