package com.example.actioneersapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {

    private List<User> productList;
    public RecycleAdapter(List<User> productList){
        this.productList=productList;
    }



    @NonNull
    @Override
    public RecycleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.MyViewHolder holder, int position) {
        User user = productList.get(position);
        holder.productName.setText(user.getProductname());
        holder.productImage.setImageResource(user.getImageView());

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView productName;
        public ImageView productImage;
        public MyViewHolder(View itemView){
            super(itemView);
            productName=itemView.findViewById(R.id.product_name);
            productImage = itemView.findViewById(R.id.product_img);
        }
    }


}




