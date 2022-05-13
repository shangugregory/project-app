package com.example.actioneersapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ImageView profile;
    protected String names[] = {"Kitchen", "funiture", "Electronics", "Agriculture"};
    protected int images[] ={R.drawable.kitchen,R.drawable.funiture,R.drawable.electronics,R.drawable.agricuture };
    protected List<User> productList = new ArrayList<>();
    protected RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        prepareTheList();

        RecycleAdapter adapter = new RecycleAdapter(productList);
        recyclerView.setAdapter(adapter);





        profile = (ImageView) findViewById(R.id.profile);



        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, LogIn.class);
                startActivity(intent);
            }
        });
    }
    private void prepareTheList(){
        int count = 0;
        for (String name : names)
        {
            User user = new User();
            productList.add(user);
            count++;
        }

    }



}