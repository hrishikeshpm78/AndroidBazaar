package com.example.bazaar.mainactivities;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bazaar.R;

public class SearchViewHolder extends RecyclerView.ViewHolder {
    TextView pName;
    ImageView image;
    TextView category;
    TextView price;
    CardView card;

    SearchViewHolder(View itemView) {
        super(itemView);
        pName = (TextView) itemView.findViewById(R.id.product_search_text);
        image = (ImageView) itemView.findViewById(R.id.imagesearch);
        category=(TextView) itemView.findViewById(R.id.search_category);
        price=(TextView) itemView.findViewById(R.id.price_search);
        card=(CardView) itemView.findViewById(R.id.search_item_view);
    }
//    public void bind(SearchObject obj){
//        pName.setText(obj.getProductName());
//        category.setText(obj.getCategory());
//        Glide.with(image.getContext())
//                .load(obj.getProductImage())
//                .into(image);
//
//    }
}
