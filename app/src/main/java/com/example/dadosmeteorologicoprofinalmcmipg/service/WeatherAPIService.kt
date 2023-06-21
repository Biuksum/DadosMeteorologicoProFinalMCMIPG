package com.example.dadosmeteorologicoprofinalmcmipg.service

import com.example.dadosmeteorologicoprofinalmcmipg.model.WeatherModel
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class WeatherAPIService {

    //https://api.openweathermap.org/data/2.5/weather?q=guarda&appid=127e69b776851f15c3facc34771cd51e

    private val BASE_URL = "https://api.openweathermap.org/"
    private val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(WeatherAPI::class.java)

    fun getDataService(): Single<WeatherModel>{
        return api.getData()
    }
}