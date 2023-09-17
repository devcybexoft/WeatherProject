package com.example.weatherproject

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        val requestButton = findViewById<Button>(R.id.requestbutton)
        val weatherTextView = findViewById<TextView>(R.id.weather_text_view)
        requestButton.setOnClickListener {
            val client = ApiClient.retrofit.create(ApiInterface::class.java)

            client.getWeatherRx().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({ data ->
                    weatherTextView.text =
                        "Температура ${data?.data?.temperature} Вітер ${data?.data?.wind}: ${data?.data?.description}"
            },
                    { error -> Toast.makeText(this, "Request error", Toast.LENGTH_SHORT) })

            /* client.getWeather().enqueue(
                   object : Callback<WeatherResponse> {
                       override fun onResponse(
                           call: Call<WeatherResponse>,
                           response: retrofit2.Response<WeatherResponse>
                       ) {
                           if (response.isSuccessful) {
                               val data = response.body()?.data
                               val msgText = "Температура ${data?.temperature} Вітер ${data?.wind}: ${data?.description}"
                               weatherTextView.text = msgText
                               Toast.makeText(this@MainActivity, msgText, Toast.LENGTH_LONG).show()

                           }
                       }

                       override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                           weatherTextView.text = t.message
                           Toast.makeText(this@MainActivity, "Помилка: ${t.message}", Toast.LENGTH_LONG).show()
                       }

                   })*/

        }
    }
}