package com.example.goron.userdiplom.Interface;

import com.example.goron.userdiplom.Model.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Service  {



    ////
    ////service
    ////


    // http://example.com/api/v1/users/
    // Еще не пробывал в работе (необходимо передавать поля name. surname, number, password ) необходимо из класса users исключить для передачи POST id , timestamp
    // Регистрирует нового пользователя в системе. Поле number является логином пользователя, поле passport его паролем
    @POST("service/users")
    Call<Void> registrationUser(@Body Users users);


}
