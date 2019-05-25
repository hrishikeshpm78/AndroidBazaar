package com.example.bazaar.mainactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.bazaar.R;
import com.example.bazaar.pojos.product.Product;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends AppCompatActivity {
    private Button button;
    CartPageAdapter adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_page);
        button=findViewById(R.id.buyNow);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CartPage.this, CheckoutPage.class);
                startActivity(intent);
            }
        });

        List<Product> list = new ArrayList<>();
        list = getData();

        recyclerView = (RecyclerView)findViewById(R.id.recyclerCart);
        adapter = new CartPageAdapter(list, getApplication());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(CartPage.this));
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
