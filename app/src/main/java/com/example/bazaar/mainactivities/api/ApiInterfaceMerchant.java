package com.example.bazaar.mainactivities.api;

import com.example.bazaar.pojos.merchant.MerchantResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterfaceMerchant {
    @GET("/merchant/getmerchants")
    Call<List<MerchantResponse>> getOrder(@Query("pId") int i);
}
