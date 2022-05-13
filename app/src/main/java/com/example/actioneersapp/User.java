package com.example.actioneersapp;

import android.widget.ImageView;

public class User {
    String Productname;
    ImageView imageView;

    public User() {
        this.imageView=imageView;
        this.Productname=Productname;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public String getProductname() {
        return Productname;
    }

    public void setProductname(String productname) {
        Productname = productname;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
}



