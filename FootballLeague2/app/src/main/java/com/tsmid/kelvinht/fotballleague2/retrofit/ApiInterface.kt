package com.tsmid.kelvinht.fotballleague2.retrofit

import com.tsmid.kelvinht.fotballleague2.BuildConfig
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.net.URL

interface ApiInterface {
    
    val url2: String
        get() = BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/"

    object JSONURL {
        const val url = BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/"
    }

    fun doRequest(url: String): Deferred<String> = GlobalScope.async {
        URL(url).readText()
    }

    @GET("lookupleague.php?")
    fun getFootballDetail(
        @Query("id") idLeague: String
    ): Call<String>

    @GET("eventspastleague.php?")
    fun getPreviousMatch(
        @Query("id") idLeague: String?
    ): Call<String>

    @GET("eventsnextleague.php?")
    fun getNextMatch(
        @Query("id") idLeague: String?
    ): Call<String>

    @GET("lookupevent.php?")
    fun getDetailMatch(
        @Query("id") idLeague: String?
    ): Call<String>

    @GET("searchevents.php?")
    fun getSearchFootballMatch(
        @Query("e") query: String?
    ): Call<String>

}