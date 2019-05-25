package com.example.bazaar.mainactivities;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bazaar.R;

public class SearchViewHolder extends RecyclerView.ViewHolder {
    TextView pName;
    ImageView image;


    SearchViewHolder(View itemView) {
        super(itemView);
        pName = (TextView) itemView.findViewById(R.id.product_search_text);
        image = (ImageView) itemView.findViewById(R.id.imagesearch);
    }
}
