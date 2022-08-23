package com.example.asm_anhdroidnetworking.Data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofitBuilder {
    public static Retrofit retrofit;
    public static Retrofit getInstance(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl("https://www.flickr.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
