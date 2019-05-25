package com.example.bazaar.mainactivities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bazaar.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrderViewHolder> {

    List<OrderObject> list = Collections.emptyList();
    Context context;

    public OrdersAdapter(List<OrderObject> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View photoView = inflater.inflate(R.layout.order_item,
                viewGroup, false);

        OrderViewHolder viewHolder = new OrderViewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder orderViewHolder, int i) {
        orderViewHolder.productOrdername.setText(list.get(i).getpName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private List<OrderObject> getData()
    {
        List<OrderObject> list = new ArrayList<>();
        OrderObject p=new OrderObject("iphone",56700,"12-07-08","cod");
        list.add(p);
        list.add(p);
        list.add(p);
        list.add(p);
        list.add(p);
        list.add(p);
        return list;
    }
}
