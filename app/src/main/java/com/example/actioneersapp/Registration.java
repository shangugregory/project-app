package com.example.actioneersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Registration extends AppCompatActivity {
TextView logIn;
Button register;
EditText rgEmail, rgfName, rgLname,rgOtherName, rgAge, rgId, rgPwrd, rgConPwrd;
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

        rgEmail = (EditText) findViewById(R.id.register_user_Email);
        rgfName = (EditText) findViewById(R.id.register_first_name);
        rgLname = (EditText) findViewById(R.id.register_last_name);
        rgOtherName=(EditText) findViewById(R.id.register_other_name);
        rgAge = (EditText) findViewById(R.id.register_age);
        rgId = (EditText) findViewById(R.id.register_id_no);
        rgPwrd=(EditText) findViewById(R.id.register_user_password);
        rgConPwrd=(EditText) findViewById(R.id.register_confirm_user_password);



        register = (Button) findViewById(R.id.register_btn);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rEmail = rgEmail.getText().toString().trim();
                String rFname = rgfName.getText().toString().trim();
                String rLname = rgLname.getText().toString().trim();
                String rOName = rgOtherName.getText().toString().trim();
                String rAge = rgAge.getText().toString().trim();
                String rPwd = rgPwrd.getText().toString().trim();
                String rConPwrd = rgConPwrd.getText().toString().trim();


                if(TextUtils.isEmpty(rEmail)){
                    rgEmail.setError("Email is Required");
                    return;
                }

                if(TextUtils.isEmpty(rFname)){
                    rgfName.setError("First Name Can not be empty");
                    return;
                }
                if (TextUtils.isEmpty(rLname)){
                    rgLname.setError("Last name can not be empty");
                    return;
                }
                if (TextUtils.isEmpty(rAge)){
                    rgAge.setError("Age Can Not Empty");
                    return;
                }
                if (Double.parseDouble(rAge)>18){
                    rgAge.setError("You have To be atleast over 18 years to Participate");
                    return;
                }

                if(TextUtils.isEmpty(rPwd)){
                    rgPwrd.setError("PassWord Can not be Empty");
                    return;
                }
                if (TextUtils.isEmpty(rConPwrd)){
                    rgConPwrd.setError("Please Confirm your Password");
                    return;
                }
                if (rConPwrd != rConPwrd){
                    rgPwrd.setError("Password Missmartch");
                    return;
                }


            }
        });








    }
}