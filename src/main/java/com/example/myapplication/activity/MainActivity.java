package com.example.myapplication.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText box1, box2;
    CheckBox check;
    private FirebaseAuth auth;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        box1 = (EditText) findViewById(R.id.emailbox1);
        box2 = (EditText) findViewById(R.id.passbox1);
        check = findViewById(R.id.remember);


    }

    public void login(View v) {
        final String mail = box1.getText().toString().trim();
        final String pw = box2.getText().toString().trim();
        if (mail.equals("")) {
            Toast.makeText(MainActivity.this, "You must enter your email", Toast.LENGTH_LONG).show();
        } else if (pw.equals("")) {
            Toast.makeText(MainActivity.this, "You must enter your password", Toast.LENGTH_LONG).show();
        } else {
            auth.signInWithEmailAndPassword(mail, pw)
                    .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent go = new Intent(MainActivity.this, NavigationActivity.class);
                                startActivity(go);
                                finish();

                            } else {
                                Toast.makeText(MainActivity.this, "Enter U Email and Password", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    public void register(View v) {
        Intent go = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(go);
    }


}








