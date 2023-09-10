package com.example.weatherproject
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/Kyiv")
    fun getWeather():Call<WeatherResponse>

    @GET("Kyiv")
    fun getWeatherRx(): Single<WeatherResponse>
}