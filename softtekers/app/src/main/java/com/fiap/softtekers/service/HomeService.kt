package com.fiap.softtekers.service
import com.fiap.softtekers.model.Form
import retrofit2.Call
import retrofit2.http.GET

interface HomeService {

    //Pego todos os forms suas ultimas responstas
    @GET("/json/")
    fun getAllFroms(): List<Call<Form>>

}