package com.example.bazaar.mainactivities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bazaar.R;
import com.example.bazaar.pojos.product.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartPageAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    List<Product> list = Collections.emptyList();

    Context context;

    public CartPageAdapter(List<Product> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View photoView = inflater.inflate(R.layout.card_view,
                viewGroup, false);

        RecyclerViewHolder viewHolder = new RecyclerViewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int position) {

        recyclerViewHolder.pName.setText(list.get(position).getName());



        //recyclerViewHolder.examDate.setText(list.get(position).date);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    private List<Product> getData()
    {
        List<Product> list = new ArrayList<>();
        Product p=new Product("hihihihihihihih");
        list.add(p);
        list.add(p);
        list.add(p);
        list.add(p);
        list.add(p);
        list.add(p);
        return list;
    }
}
