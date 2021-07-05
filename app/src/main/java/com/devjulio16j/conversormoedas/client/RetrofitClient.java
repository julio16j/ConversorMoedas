package com.devjulio16j.conversormoedas.client;

import com.devjulio16j.conversormoedas.api.QuotationApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient instance = null;
    private QuotationApi myQuotationApi;

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(QuotationApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myQuotationApi = retrofit.create(QuotationApi.class);
    }

    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public QuotationApi getMyQuotationApi() {
        return myQuotationApi;
    }
}
