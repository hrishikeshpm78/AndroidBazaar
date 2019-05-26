package com.example.bazaar.mainactivities.homefragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bazaar.R;
import com.example.bazaar.mainactivities.CartPage;

import java.util.ArrayList;
import java.util.List;

public class ProductDetails extends Fragment {
    View myView;
    private Button addToCartBtn;
    private Button buyNowBtn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView =inflater.inflate(R.layout.product_details,container,false);

        ArrayList<String> example=new ArrayList<String>();
        ArrayList<String> example2=new ArrayList<String>();
        example.add("1st item");
        example.add("2nd item");
        example.add("3rd item");
        example.add("1st item");
        example.add("2nd item");
        example.add("3rd item");
        LinearLayout attrLayout=(LinearLayout) myView.findViewById(R.id.pd_attributes);
        LinearLayout merchLayout=(LinearLayout) myView.findViewById(R.id.pd_merchants);

        for (String text:
             example) {
            TextView textView=new TextView(getContext());
            textView.setText(text);
            textView.setTextSize(30);
            textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            attrLayout.addView(textView);
        }
        for (String text:
                example) {
            TextView textView=new TextView(getContext());
            textView.setText(text);
            textView.setTextSize(30);
            textView.setGravity(View.TEXT_ALIGNMENT_CENTER);

            merchLayout.addView(textView);
        }

        addToCartBtn=(Button) myView.findViewById(R.id.pd_addToCart);
        buyNowBtn=(Button) myView.findViewById(R.id.pd_buyNow);

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart();
            }
        });
        buyNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buyNow();
            }
        });
        return myView;
    }

    private void buyNow() {
        //add the item to cart and go to cart page
        Intent intent=new Intent(getContext(), CartPage.class);
        startActivity(intent);
    }

    private void addToCart() {
                // integrate with  cart here.
        Toast toast=Toast.makeText(getContext()," item added to cart",Toast.LENGTH_LONG);
        toast.show();
    }

}
