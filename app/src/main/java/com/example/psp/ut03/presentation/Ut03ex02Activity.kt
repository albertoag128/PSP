package com.example.psp.ut03.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.psp.ut03.data.remote.models.AlertsApiModel
import com.example.psp.ut03.data.remote.models.RetroFitApiClient
import com.example.psp.ut03.domain.Data


class Ut03ex02Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val apiClient = RetroFitApiClient()

        Thread{
            //DEVOLVER TODAS LAS ALERTAS
            val alerts = apiClient.getAlerts()
            Log.d("@dev", "------------------------------------------------------------------------------------------")
            if (alerts != null) {
                Log.d("@dev", "Status code: ${alerts.statusCode}")
                Log.d("@dev", "------------------------------------------------------------------------------------------")
            }
            showAlerts(alerts)
            Log.d("@dev", "------------------------------------------------------------------------------------------")

            //DEVOLVER UNA ALERTA POR ID RECOGIDA DE LA LISTA ENTERA
            val alert = apiClient.getSingleAlertFromList("3053125", apiClient.getAlerts())
            Log.d("@dev", "Alerta: $alert")

            //DEVOLVER UNA ALERTA POR ID
            Log.d("@dev", "------------------------------------------------------------------------------------------")
            val singleAlert = apiClient.getAlert("3053125")
            Log.d("@dev", "Alerta: $singleAlert")
            Log.d("@dev", "------------------------------------------------------------------------------------------")
        }.start()
    }

    fun showAlerts(alerts:AlertsApiModel?){
        if (alerts != null) {
            for(d: Data in alerts.data){
                Log.d("@dev", d.toString())
            }
        }
    }

}