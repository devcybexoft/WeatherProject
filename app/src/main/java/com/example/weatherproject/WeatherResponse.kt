package com.example.weatherproject
import com.google.gson.annotations.SerializedName

data class WeatherResponse(val data: WeatherState)

data class WeatherState (

    @SerializedName("temperature" ) var temperature : String?             = null,
    @SerializedName("wind"        ) var wind        : String?             = null,
    @SerializedName("description" ) var description : String?             = null,
    @SerializedName("forecast"    ) var forecast    : ArrayList<Forecast> = arrayListOf()

)

data class Forecast (

    @SerializedName("day"         ) var day         : String? = null,
    @SerializedName("temperature" ) var temperature : String? = null,
    @SerializedName("wind"        ) var wind        : String? = null

)