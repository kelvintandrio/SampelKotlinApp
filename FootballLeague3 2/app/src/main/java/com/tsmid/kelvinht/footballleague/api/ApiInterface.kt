package com.tsmid.kelvinht.footballleague.api

import com.tsmid.kelvinht.footballleague.BuildConfig
import com.tsmid.kelvinht.footballleague.model.MatchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    object JSONURL {
        const val url = BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/"
    }

    @GET("lookupleague.php?")
    fun getFootballDetail(@Query("id") idLeague: String): Call<MatchResponse>

    @GET("eventspastleague.php?")
    fun getPreviousMatch(@Query("id") idLeague: String?): Call<String>

    @GET("eventsnextleague.php?")
    fun getNextMatch(@Query("id") idLeague: String?): Call<String>

    @GET("lookupevent.php?")
    fun getDetailMatch(@Query("id") idLeague: String?): Call<String>

    @GET("searchevents.php?")
    fun getSearchFootballMatch(@Query("e") query: String?): Call<String>
}