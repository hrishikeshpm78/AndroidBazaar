package com.example.bazaar.mainactivities.homefragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bazaar.R;

import java.util.ArrayList;
import java.util.List;

public class ProductDetails extends Fragment {
    View myView;
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

        return myView;
    }
    //        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        TextView t = new TextView();
//        LinearLayout linearLayout = new LinearLayout();
//        linearLayout.set
}
