package com.tsmid.kelvinht.footballleague.api

import com.tsmid.kelvinht.footballleague.model.DetailFootball
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MatchRepository {

    fun getDetailMatch(id: String, callback: MatchRepositoryCallback<DetailFootball?>) {
        MyRetrofit
            .createService(ApiInterface::class.java)
            .getFootballDetail(id)
            .enqueue(object : Callback<DetailFootball?> {
                override fun onFailure(call: Call<DetailFootball?>?, t: Throwable?) {
                    callback.onDataError()
                }

                override fun onResponse(call: Call<DetailFootball?>?, response: Response<DetailFootball?>?) {
                    response?.let {
                        if (it.isSuccessful) {
                            callback.onDataLoaded(it.body())
                            callback.getNameFootball(it.body()?.events?.get(0)?.nameFootball)
                        }
                        else {
                            callback.onDataError()
                        }
                    }
                }
            })
    }
}