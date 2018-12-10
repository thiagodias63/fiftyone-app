package com.example.thiagodias.fiftyone.services;

import com.example.thiagodias.fiftyone.model.ListaOrdem;
import com.example.thiagodias.fiftyone.model.Ordem;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface ServiceOrdem {
    @POST("ordem")
    Call<ListaOrdem> cadastrar(@Body Ordem o);

    @GET("ordem")
    Call<ListaOrdem> listarOrdens();

    @GET("ordem/pendentes")
    Call<ListaOrdem> listarOrdensPendentes();

    @GET("ordem/completadas")
    Call<ListaOrdem> listarOrdensCompletadas();

    @PUT("ordem/{id}")
    Call<ListaOrdem> finalizar(@Path("id") String indice);
}
