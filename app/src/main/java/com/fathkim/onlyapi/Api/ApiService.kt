package com.fathkim.onlyapi.Api

import com.fathkim.onlyapi.data.ItemUserResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")

    fun getListUser() : Call<ArrayList<ItemUserResponse>>
}