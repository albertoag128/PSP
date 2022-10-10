package com.example.psp.ut02.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.psp.ut02.data.remote.RetroFitApiClient

class Ut02Ex01Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Thread{
            val client = RetroFitApiClient()

            val users = client.getUsers()
            Log.d("@dev", "Users: $users")
        }.start()
    }

}