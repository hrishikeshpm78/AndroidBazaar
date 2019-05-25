package com.example.bazaar.mainactivities;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bazaar.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView pName;
    ImageView image;


    RecyclerViewHolder(View itemView)
    {
        super(itemView);
        pName = (TextView)itemView.findViewById(R.id.product_text);
        image = (ImageView)itemView.findViewById(R.id.imagerec);
    }
}