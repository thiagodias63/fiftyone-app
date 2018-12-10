package com.example.thiagodias.fiftyone.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListaCliente {
    @SerializedName("sucesso")
    public boolean status;
    public List<Cliente> lista;

    public List<Cliente> getLista() {
        return lista;
    }

    public void setLista(List<Cliente> lista) {
        this.lista = lista;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
