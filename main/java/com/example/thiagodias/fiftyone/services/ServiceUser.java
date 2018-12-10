package com.example.thiagodias.fiftyone.services;

import com.example.thiagodias.fiftyone.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServiceUser {
    @POST("login")
    Call<User> logar(@Body User u);
}
