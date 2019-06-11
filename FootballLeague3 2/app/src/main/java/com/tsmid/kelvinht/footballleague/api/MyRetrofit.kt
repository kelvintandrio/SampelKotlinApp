package com.tsmid.kelvinht.footballleague.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyRetrofit {

    private fun iniRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(ApiInterface.JSONURL.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun <T> createService(service: Class<T>): T {
        return iniRetrofit().create(service)
    }

}