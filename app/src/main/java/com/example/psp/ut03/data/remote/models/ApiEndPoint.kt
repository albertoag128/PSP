package com.example.psp.ut03.data.remote.models


import com.example.psp.ut03.domain.Data
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndPoint {
    @GET("api/public/alerts")
    fun getAlerts(): Call<AlertsApiModel>

    @GET("api/public/alerts/{alert_id}")
    fun getAlert(@Path("alert_id") alert_id:String): Call<DataApiModel>
}