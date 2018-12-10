package com.example.thiagodias.fiftyone.model;

import com.google.gson.annotations.SerializedName;

public class Usuario {
    @SerializedName("usuario")
    public String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
