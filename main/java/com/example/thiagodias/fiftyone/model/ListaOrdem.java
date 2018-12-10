package com.example.thiagodias.fiftyone.model;

import java.util.List;

public class ListaOrdem {
    public boolean status;
    public List<Ordem> lista;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Ordem> getLista() {
        return lista;
    }

    public void setLista(List<Ordem> lista) {
        this.lista = lista;
    }
}
