package com.example.bazaar.mainactivities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bazaar.R;
import com.example.bazaar.pojos.product.Product;
import com.example.bazaar.pojos.user.ResponseFromUser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartPageAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    List<CartObject> list = Collections.emptyList();

    Context context;

    public CartPageAdapter(List<CartObject> list, Context context) {
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
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, final int position) {

        recyclerViewHolder.pName.setText(list.get(position).getProdName());
        recyclerViewHolder.pPrice.setText(Integer.toString(list.get(position).getProdPrice()));
        recyclerViewHolder.quantity.setText(Integer.toString(list.get(position).getQuantity()));
        Glide.with(recyclerViewHolder.image.getContext())
                .load(list.get(position).getImgUrl())
                .into(recyclerViewHolder.image);
        recyclerViewHolder.cartDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<ResponseFromUser> call=MainActivity.apiInterface.remFromCart(list.get(position).getCartItem());
                call.enqueue(new Callback<ResponseFromUser>() {
                    @Override
                    public void onResponse(Call<ResponseFromUser> call, Response<ResponseFromUser> response) {
                        ResponseFromUser responseFromUser=response.body();
                        Log.e("cartdelete",responseFromUser.getStatus());

                    }

                    @Override
                    public void onFailure(Call<ResponseFromUser> call, Throwable t) {
                        Log.e("cartdelete","connection failure");
                    }
                });

                list.remove(position);
                notifyItemRemoved(position);




            }
        });


        //recyclerViewHolder.examDate.setText(list.get(position).date);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
//    private List<Product> getData()
//    {
//        List<Product> list = new ArrayList<>();
//        Product p=new Product("hihihihihihihih");
//        list.add(p);
//        list.add(p);
//        list.add(p);
//        list.add(p);
//        list.add(p);
//        list.add(p);
//        return list;
//    }
}
