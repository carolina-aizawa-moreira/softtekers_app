package com.fiap.softtekers.service
import com.fiap.softtekers.model.FormAnalisys
import retrofit2.Call
import retrofit2.http.GET

interface AnalisysService {

    //Pego todos os resultados consolidados
    @GET("/json/")
    fun getAllFroms(): List<Call<FormAnalisys>>

}