package com.fiap.softtekers.service
import com.fiap.softtekers.model.Form
import retrofit2.http.GET

interface HomeService {

    //Pego todos os forms suas ultimas responstas
    @GET("/forms")
    suspend fun getAllFroms(): List<Form>

}