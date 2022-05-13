package com.example.actioneersapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogIn extends AppCompatActivity {
    
     TextView register;
     EditText logInEmail, logInPasssword;
     Button logInBtn;
     FirebaseAuth firebaseAuth;

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

        firebaseAuth=FirebaseAuth.getInstance();


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

                firebaseAuth.signInWithEmailAndPassword(email, passwrd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LogIn.this, "Log In Successful!", Toast.LENGTH_LONG);
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }

                        else {
                            Toast.makeText(LogIn.this, "Error Logging in!"+task.getException().getMessage(), Toast.LENGTH_LONG);
                        }

                    }
                });
            }
        });


    }
}