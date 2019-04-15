package com.example.myapplication.activity;

import  android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class RegisterActivity extends AppCompatActivity {
EditText username,email,phone,pass;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        auth=FirebaseAuth.getInstance();
        username=findViewById(R.id.username);
        email=findViewById(R.id.emailbox1);
        phone=findViewById(R.id.phone);
        pass=findViewById(R.id.password);

    }
    public void save(View v){
        String name=username.getText().toString().trim();
        String mail=email.getText().toString().trim();
        String mobile=phone.getText().toString().trim();
        String pas=pass.getText().toString().trim();
        if (name.isEmpty()){
            username.setError("Input U Name");
        } if (mail.isEmpty()){
            username.setError("Input U Email");
        } if (mobile.isEmpty()){
            username.setError("Input U Number Phone");
        } if (mobile.length()<11){
            username.setError("U Number Uncorrected");
        } if (pas.isEmpty()){
            username.setError("Input U Password");
        } if (pas.length()<6){
            username.setError("U Password Week");
        }


        auth.createUserWithEmailAndPassword(mail, pas)
                .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Intent go=new Intent(RegisterActivity.this,MainActivity.class);
                            startActivity(go);
                            finish();
                        }
                    }
                });
    }
}
