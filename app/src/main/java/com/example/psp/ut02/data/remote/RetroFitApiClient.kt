package com.example.psp.ut02.data.remote

import com.example.psp.ut02.data.remote.models.UsersApiModel
import com.example.psp.ut02.domain.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class RetroFitApiClient {

    private val urlEndPoint = "https://jsonplaceholder.typicode.com/"
    private var apiEndPoints: ApiEndPoint

    init {
        apiEndPoints = buildApiEndPoints()
    }

    private fun buildClient(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(urlEndPoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun buildApiEndPoints(): ApiEndPoint{
       return buildClient().create(ApiEndPoint::class.java)
    }

    fun getUsers(): List<UsersApiModel>?{
        val callUsers = apiEndPoints.getUsers()
        val response = callUsers.execute()
        return if(response.isSuccessful){
            val users = response.body()
            users ?: emptyList()
        }else{
            emptyList()
        }
    }

    fun getUser(userId:Int): UsersApiModel?{
        val callUser = apiEndPoints.getUser(userId)
        val response = callUser.execute()
        return if(response.isSuccessful){
            response.body()
        }else{
            null
        }
    }

}