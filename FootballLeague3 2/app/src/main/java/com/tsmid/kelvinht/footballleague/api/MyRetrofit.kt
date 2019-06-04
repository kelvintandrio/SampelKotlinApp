package com.tsmid.kelvinht.footballleague.api

import com.tsmid.kelvinht.footballleague.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object MyRetrofit {

    private fun iniRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()
    }

    fun <T> createService(service: Class<T>): T {
        return iniRetrofit().create(service)
    }

}