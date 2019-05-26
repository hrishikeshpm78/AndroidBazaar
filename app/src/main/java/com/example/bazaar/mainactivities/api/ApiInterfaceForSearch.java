package com.example.bazaar.mainactivities.api;

import com.example.bazaar.pojos.product.Product;
import com.example.bazaar.pojos.search.SearchResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterfaceForSearch
{

    @GET("rest/search")
    Call<SearchResponse> getProducts(@Query("text")String name);

}