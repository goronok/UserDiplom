package com.example.goron.userdiplom.Interface;

import com.example.goron.userdiplom.Model.DatesFestival;
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


    // http://example.com/api/v1/service/dates
    // Возвращает массив дат фестиваля отсортированный по возрастанию
    @GET("service/dates")
    Call<DatesFestival> getDatesFestival();





}
