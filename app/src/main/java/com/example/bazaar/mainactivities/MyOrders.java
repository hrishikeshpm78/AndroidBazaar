package com.example.bazaar.mainactivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.bazaar.R;

import java.util.ArrayList;
import java.util.List;

public class MyOrders extends AppCompatActivity {
    RecyclerView recyclerView;
    OrdersAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);


        List<OrderObject> list = new ArrayList<>();
        list = getData();

        recyclerView = (RecyclerView)findViewById(R.id.recyclerOrder);
        adapter = new OrdersAdapter(list, getApplication());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MyOrders.this));

    }
    private List<OrderObject> getData()
    {
        List<OrderObject> list = new ArrayList<>(); //Adding happens here
        OrderObject p=new OrderObject("iphone222",56700,"12-07-08","cod");
        list.add(p);
        list.add(p);
        list.add(p);
        list.add(p);
        list.add(p);
        list.add(p);
        return list;
    }
}
