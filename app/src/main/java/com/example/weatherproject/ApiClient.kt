package com.example.weatherproject

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    /*val retrofit:Retrofit = Retrofit.Builder()
        .baseUrl("https://goweather.herokuapp.com/weather/")
        .client(OkHttpClient.Builder().build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()*/

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://goweather.herokuapp.com/weather/")
        .client(OkHttpClient.Builder().build())
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(OkHttpClient())
        .build()
}