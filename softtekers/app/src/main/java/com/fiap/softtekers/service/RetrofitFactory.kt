package br.com.fiap.consultacep.service

import com.fiap.softtekers.service.AnalisysService
import com.fiap.softtekers.service.CheckInService
import com.fiap.softtekers.service.HomeService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val URL = "htps://challenge-softtek-production.up.railway.app/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getHomeService(): HomeService {
        return retrofitFactory.create(HomeService::class.java)
    }
    fun getAnalisysService(): AnalisysService {
        return retrofitFactory.create(AnalisysService::class.java)
    }

    fun getCheckInService(): CheckInService {
        return retrofitFactory.create(CheckInService::class.java)
    }


}