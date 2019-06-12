package com.tsmid.kelvinht.footballleague.api

import com.tsmid.kelvinht.footballleague.BuildConfig
import com.tsmid.kelvinht.footballleague.model.DetailFootball
import com.tsmid.kelvinht.footballleague.model.MatchFootball
import com.tsmid.kelvinht.footballleague.model.SearchMatchFootball
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    object JSONURL {
        const val url = BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/"
    }

    @GET("lookupleague.php?")
    fun getFootballDetail(@Query("id") idLeague: String): Call<DetailFootball>

    @GET("eventspastleague.php?")
    fun getPreviousMatch(@Query("id") idLeague: String?): Call<MatchFootball>

    @GET("eventsnextleague.php?")
    fun getNextMatch(@Query("id") idLeague: String?): Call<MatchFootball>

    @GET("lookupevent.php?")
    fun getDetailMatch(@Query("id") idLeague: String?): Call<String>

    @GET("searchevents.php?")
    fun getSearchFootballMatch(@Query("e") query: String?): Call<SearchMatchFootball>
}