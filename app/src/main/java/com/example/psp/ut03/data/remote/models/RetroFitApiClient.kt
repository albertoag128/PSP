package com.example.psp.ut03.data.remote.models

import android.util.Log
import com.example.psp.ut02.data.remote.models.UsersApiModel
import com.example.psp.ut02.domain.User
import com.example.psp.ut03.domain.Data
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class RetroFitApiClient {

    private val urlEndPoint = "https://plagricola.sitehub.es/"
    private var apiEndPoints: ApiEndPoint

    init {
        apiEndPoints = buildApiEndPoints()
    }

    private fun buildClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlEndPoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun buildApiEndPoints(): ApiEndPoint {
        return buildClient().create(ApiEndPoint::class.java)
    }


    fun getAlerts(): AlertsApiModel?{
        val callAlerts = apiEndPoints.getAlerts()
        val response = callAlerts.execute()
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }


    fun getAlert(alert_id: String): DataApiModel? {
        val callAlert = apiEndPoints.getAlert(alert_id)
        val response = callAlert.execute()
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }


    fun getSingleAlertFromList(alert_id: String, model: AlertsApiModel?): Data? =
        getAlerts()?.data?.first { alert -> alert.alert_id == alert_id }


}