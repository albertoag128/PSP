package com.example.psp.ut02.data.remote

import com.example.psp.ut02.data.remote.models.UsersApiModel
import com.example.psp.ut02.domain.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ApiEndPoint {
    @GET("users")
    fun getUsers(): Call<List<UsersApiModel>>

    @GET("users/{userId}")
    fun getUser(@Path ("userId") userId:Int): Call<UsersApiModel>

}