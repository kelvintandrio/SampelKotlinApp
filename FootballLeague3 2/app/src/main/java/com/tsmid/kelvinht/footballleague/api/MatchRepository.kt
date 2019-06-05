package com.tsmid.kelvinht.footballleague.api

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MatchRepository {

    fun getDetailMatch(id: String, callback: MatchRepositoryCallback<String?>) {
        MyRetrofit
            .createService(ApiInterface::class.java)
            .getFootballDetail(id)
            .enqueue(object : Callback<String?> {
                override fun onFailure(call: Call<String?>?, t: Throwable?) {
                    Log.e("Error","Gagal "+t.toString())
                    callback.onDataError()
                }

                override fun onResponse(call: Call<String?>?, response: Response<String?>?) {
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