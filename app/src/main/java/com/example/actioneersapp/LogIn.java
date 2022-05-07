package com.example.actioneersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LogIn extends AppCompatActivity {
    
     TextView register;
     EditText logInEmail, logInPasssword;
     Button logInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        logInBtn=(Button) findViewById(R.id.log_in_btn);
        logInEmail = (EditText) findViewById(R.id.log_in_email);
        logInPasssword= (EditText) findViewById(R.id.log_in_user_password);
        register= (TextView) findViewById(R.id.txtRegister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogIn.this, Registration.class);
                startActivity(intent);

            }
        });


        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = logInEmail.getText().toString().trim();
                String passwrd = logInPasssword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    logInEmail.setError("Email Is Required");
                    return;
                }

                if(TextUtils.isEmpty(passwrd)){
                    logInPasssword.setError("Password is Required");
                    return;
                }
            }
        });


    }
}