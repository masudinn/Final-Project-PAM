package com.masudinn.pam_2087.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    private  static  final  String BASE_URL="https://www.thesportsdb.com/api/v1/json/1/";

    public static Server getApi() {
        //Builder Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Server client = retrofit.create(Server.class);

        return client;
    }
}
