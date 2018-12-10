package com.example.thiagodias.fiftyone.model;

import java.util.List;

public class ListaServico {
    public boolean status;
    public List<Servico> lista;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Servico> getLista() {
        return lista;
    }

    public void setLista(List<Servico> lista) {
        this.lista = lista;
    }
}
