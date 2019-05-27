package com.example.bazaar.mainactivities.api;

import com.example.bazaar.pojos.cart.CartDTO;
import com.example.bazaar.pojos.cart.CartResponse;
import com.example.bazaar.pojos.order.OrderDTO;
import com.example.bazaar.pojos.user.LoginRequest;
import com.example.bazaar.pojos.user.ProfileResponse;
import com.example.bazaar.pojos.user.ResponseFromUser;
import com.example.bazaar.pojos.user.SignUpForm;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiInterfaceForUser
{


    @POST("/user/signup")
    Call<ResponseFromUser> signup(@Body SignUpForm form);

    @POST("/user/login")
    Call<ResponseFromUser > login(@Body LoginRequest form);


    @GET("/user/profile")
    Call<ProfileResponse> profile(@Query("accesstoken") String token);

    @GET("/user/cart/details")
    Call<CartResponse> getCart(@Query("accesstoken") String token);

    @POST("/user/cart/add")
    Call<CartResponse> addToCart(@Body CartDTO myCart);

    @POST("/user/order/buy")
    Call<ResponseFromUser> buyNow(@Body OrderDTO myOrder);
}
