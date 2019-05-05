package algo.project.kelvin.football.retrofit

import algo.project.kelvin.football.BuildConfig
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Query

interface ApiInterface {
    object JSONURL {
//        const val url = BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/"
        const val url = "https://www.thesportsdb.com/api/v1/json/1/"
    }

    @GET("lookupleague.php?")
    fun getFootballDetail(
        @Query("id") idLeague: String
    ): Call<String>

}