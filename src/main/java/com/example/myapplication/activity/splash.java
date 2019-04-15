package com.example.myapplication.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;

import com.example.myapplication.R;

public class splash extends AppCompatActivity {
    CheckBox check;
SharedPreferences shared;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        Handler hand=new Handler();
        Runnable run=new Runnable() {
            @Override
            public void run() {
                shared=getSharedPreferences("login",MODE_PRIVATE);

                if (shared.getBoolean("checked",false)){
                    Intent splash=new Intent(splash.this, NavigationActivity.class);
                    startActivity(splash);
                }
                else {
                    Intent splash=new Intent(splash.this, MainActivity.class);
                    startActivity(splash);
                }
            }

        };
        hand.postDelayed(run,3000);

    }
}
