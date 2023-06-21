package com.example.dadosmeteorologicoprofinalmcmipg.service

import com.example.dadosmeteorologicoprofinalmcmipg.model.WeatherModel
import io.reactivex.Single
import retrofit2.http.GET

//https://api.openweathermap.org/data/2.5/weather?q=guarda&appid=127e69b776851f15c3facc34771cd51e

interface WeatherAPI {
    @GET("data/2.5/weather?q=guarda&appid=127e69b776851f15c3facc34771cd51e")
    fun getData(): Single<WeatherModel>
}