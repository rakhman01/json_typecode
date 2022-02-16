package com.rakhman.jsonplaceholder.ui.api

import com.rakhman.jsonplaceholder.ui.constant.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrovit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ConfigApi by lazy {
        retrovit.create(ConfigApi::class.java)
    }
}