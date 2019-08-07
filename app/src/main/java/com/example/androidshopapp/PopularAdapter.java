package com.example.androidshopapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
//import com.squareup.picasso.PicassoProvider;

import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ImageViewHolder> {


    private Context mcontext;
    private List<Popular> mPopulars;

    public PopularAdapter (Context context,List<Popular>populars){

        mcontext = context;
        mPopulars = populars;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View v = LayoutInflater.from(mcontext).inflate(R.layout.popular_item,parent,false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {

        Popular popularCur = mPopulars.get(position);
        holder.prod_name.setText(popularCur.getProduct_title());
        holder.prod_price.setText(popularCur.getProduct_price());
        Picasso.with(mcontext)
                .load(popularCur.getProduct_image())
                .placeholder(R.drawable.img_placeholder)
                .fit()
                .centerCrop()
                .into((Target) holder.prod_img);


    }

    @Override
    public int getItemCount() {
        return mPopulars.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{

        public TextView prod_name,prod_price,prod_img;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);

            prod_name = itemView.findViewById(R.id.prodName);
            prod_price = itemView.findViewById(R.id.prodPrice);
            prod_img = itemView.findViewById(R.id.prodImage);

        }

    }
}
