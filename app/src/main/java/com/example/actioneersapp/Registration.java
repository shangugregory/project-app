package com.example.actioneersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Registration extends AppCompatActivity {
TextView logIn;
Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        logIn=(TextView) findViewById(R.id.txtLogIn);
        register=(Button) findViewById(R.id.register_btn);
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registration.this, LogIn.class);
                startActivity(intent);

            }
        });
    }
}