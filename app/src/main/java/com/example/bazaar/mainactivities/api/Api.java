package com.example.bazaar.mainactivities.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;

/**
 * Created by Belal on 10/2/2017.
 */

public class Api {

    //  final static String BASE_URL = "http://127.0.0.1:8080/";
     String BASE_URL = null;
     Retrofit retrofit1=null;

    public Api(String url) {
        BASE_URL=url;
    }

    public    Retrofit getclient() {
        if(retrofit1==null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder()
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(BODY));

            retrofit1 = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(builder.build())
                    .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                    .build();
        }
        return  retrofit1;
    }


}
