package com.tsmid.kelvinht.footballleague.presenter

import android.annotation.SuppressLint
import android.util.Log
import com.tsmid.kelvinht.footballleague.api.ApiInterface
import com.tsmid.kelvinht.footballleague.api.MatchRepository
import com.tsmid.kelvinht.footballleague.api.MatchRepositoryCallback
import com.tsmid.kelvinht.footballleague.inter.IDetailFootballActivity
import com.tsmid.kelvinht.footballleague.inter.IDetailFootballPresenter
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

class DetailFootballPresenter(private var detailFootballActivity: IDetailFootballActivity,
                              private val matchRepository: MatchRepository) : IDetailFootballPresenter {

    override fun getDetailFootball(id : String) {

        matchRepository.getDetailMatch(id, object : MatchRepositoryCallback<String?> {
            override fun onDataLoaded(data: String?) {
                Log.i("onSuccess", "Response Berhasil")
            }

            override fun onDataError() {
                Log.i("Gagal","Response Gagal")
            }
        })


//        val retrofit = Retrofit.Builder()
//            .baseUrl(ApiInterface.JSONURL.url)
//            .addConverterFactory(ScalarsConverterFactory.create())
//            .build()
//        val api = retrofit.create(ApiInterface::class.java)
//        val call = api.getFootballDetail(id)
//
//        call.enqueue(object : Callback<String> {
//            override fun onResponse(call: Call<String>, response: Response<String>) {
//                if (response.isSuccessful) {
//                    if (response.body() != null) {
//                        Log.i("onSuccess", response.body().toString())
//                        val jsonResponse = response.body().toString()
//                        val obj = JSONObject(jsonResponse)
//                        val dataArray = obj.getJSONArray("leagues")
//                        val dataObject = dataArray.getJSONObject(0)
//
//                        detailFootballActivity.setTextNameFootball(dataObject.getString("strLeague"))
//                        detailFootballActivity.setImageLogoFootball(dataObject.getString("strLogo"))
//                        detailFootballActivity.setTextYearFootball(dataObject.getString("intFormedYear"))
//                        detailFootballActivity.setTextCountryFootball(dataObject.getString("strCountry"))
//                        detailFootballActivity.setTextWebsiteFootball(dataObject.getString("strWebsite"))
//                    }
//                    else {
//                        Log.i("onEmptyResponse", "Returned empty response")
//                    }
//                }
//                else {
//                    Log.i("Gagal","Response Gagal")
//                }
//            }
//
//            @SuppressLint("ShowToast")
//            override fun onFailure(call: Call<String>, t: Throwable) {
//                Log.i("onError", "Gagal karena "+t.message)
//            }
//        })
    }
}