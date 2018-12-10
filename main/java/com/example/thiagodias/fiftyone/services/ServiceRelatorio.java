package com.example.thiagodias.fiftyone.services;

import com.example.thiagodias.fiftyone.model.ListaCliente;
import com.example.thiagodias.fiftyone.model.ListaServico;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceRelatorio {
    @GET("servicos")
    Call<ListaServico> obterServicos();

    @GET("clientes")
    Call<ListaCliente> obterClientes();
}
