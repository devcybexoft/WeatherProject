package com.example.weatherproject
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/Kyiv")
    fun getWeather():Call<WeatherResponse>
}