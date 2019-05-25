package com.example.bazaar.mainactivities.api;

import com.example.bazaar.pojos.product.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterfaceProduct {

    @GET("product/gettoprated")
    Call<List<Product>> getProducts();
    @GET("product/getsubcategory?subcategory=mobile")
    Call<List<Product>> getSubcategorymobile();
    @GET("product/getsubcategory?subcategory=laptop")
    Call<List<Product>> getSubcategorylaptop();
    @GET("product/getsubcategory?subcategory=faishon")
    Call<List<Product>> getSubcategoryfaishon();
}
