package com.example.restapi.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InitRetrofit  {

    fun getInitRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(EndPoint.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getInitInstance(): ApiService {
        return getInitRetrofit().create(ApiService::class.java)
    }


}