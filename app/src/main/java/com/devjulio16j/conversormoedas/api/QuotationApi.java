package com.devjulio16j.conversormoedas.api;

import com.devjulio16j.conversormoedas.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuotationApi {
    String BASE_URL = "https://economia.awesomeapi.com.br/last/";
    @GET("USD-BRL,EUR-BRL,BTC-BRL,ETH-BRL")
    Call<Result> getQuotations();
}
