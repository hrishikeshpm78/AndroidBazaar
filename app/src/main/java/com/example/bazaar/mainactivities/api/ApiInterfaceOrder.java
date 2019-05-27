package com.example.bazaar.mainactivities.api;

import com.example.bazaar.pojos.order.Order;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

public interface ApiInterfaceOrder {

    @GET("/getorder/")
    Call<Order> getOrder(@Query("id") int i);

    @GET("/merchantorder/")
    Call<List<Order>> getMerchantOrder(@Query("id") int i);
    @GET("/userorder/")
    Call<List<Order>> getUserOrder(@Query("id") int i);

}
