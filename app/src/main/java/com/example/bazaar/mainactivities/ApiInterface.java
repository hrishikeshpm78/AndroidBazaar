package com.example.bazaar.mainactivities;

import com.example.bazaar.pojos.product.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
public interface ApiInterface
{

    @GET("rest/all")
    Call<List<Product>> getProducts();

}