package com.example.bazaar.mainactivities;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;

public class ApiSearch {
    final static String BASE_URL = "http://172.16.20.70:8080/";
    static Retrofit retrofit1=null;

    public static   Retrofit getclient() {
        if(retrofit1==null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder()
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(BODY));

            retrofit1 = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(builder.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return  retrofit1;
    }
}
