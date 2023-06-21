package com.example.dadosmeteorologicoprofinalmcmipg.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.example.dadosmeteorologicoprofinalmcmipg.model.WeatherModel
import com.example.dadosmeteorologicoprofinalmcmipg.service.WeatherAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposables
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

class MainViewModel {

    private val weatherAPIService = WeatherAPIService()
    private val disposable = CompositeDisposable()

    val weather_data = MutableLiveData<WeatherModel>()
    val weather_error = MutableLiveData<Boolean>()
    val weather_load = MutableLiveData<Boolean>()

    fun refreshData(){
        getDataFromAPI()
        //getDataFromLocal()
    }

    private fun getDataFromAPI() {

        weather_load.value = true
        disposable.add(
            weatherAPIService.getDataService()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<WeatherModel>(){
                    override fun onSuccess(t: WeatherModel) {
                        weather_data.value = t
                        weather_error.value = false
                        weather_error.value = false
                    }

                    override fun onError(e: Throwable) {
                        weather_error.value  = true
                        weather_load.value = false
                    }

                })
        )
    }

}