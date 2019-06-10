package com.tsmid.kelvinht.footballleague.api

import android.util.Log
import com.tsmid.kelvinht.footballleague.model.MatchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MatchRepository {

    fun getDetailMatch(id: String, callback: MatchRepositoryCallback<MatchResponse?>) {
        MyRetrofit
            .createService(ApiInterface::class.java)
            .getFootballDetail(id)
            .enqueue(object : Callback<MatchResponse?> {
                override fun onFailure(call: Call<MatchResponse?>?, t: Throwable?) {
                    Log.e("Error","Gagal "+t.toString())
                    callback.onDataError()
                }

                override fun onResponse(call: Call<MatchResponse?>?, response: Response<MatchResponse?>?) {
                    response?.let {
                        if (it.isSuccessful) {
                            Log.i("Success", "Response Sukses")
                            callback.onDataLoaded(it.body())
                        }
                        else {
                            Log.e("Error","Gagal ")
                            callback.onDataError()
                        }
                    }
                }
            })
    }
}