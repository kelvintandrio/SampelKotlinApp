package com.tsmid.kelvinht.footballleague.api

import com.tsmid.kelvinht.footballleague.model.DetailFootball
import com.tsmid.kelvinht.footballleague.model.MatchFootball
import com.tsmid.kelvinht.footballleague.model.SearchMatchFootball
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
                            callback.getLogoFootball(it.body()?.events?.get(0)?.logoFootball)
                            callback.getYearFootball(it.body()?.events?.get(0)?.yearFootball)
                            callback.getCountryFootball(it.body()?.events?.get(0)?.countryFootball)
                            callback.getWebsiteFootball(it.body()?.events?.get(0)?.websiteFootball)
                        }
                        else {
                            callback.onDataError()
                        }
                    }
                }
            })
    }

    fun getPreviousMatch(id: String, callback: MatchRepositoryCallbackFootballMatch<MatchFootball?>) {
        MyRetrofit
            .createService(ApiInterface::class.java)
            .getPreviousMatch(id)
            .enqueue(object : Callback<MatchFootball?> {
                override fun onFailure(call: Call<MatchFootball?>?, t: Throwable?) {
                    callback.onDataErrorFootballMatch()
                }

                override fun onResponse(call: Call<MatchFootball?>?, response: Response<MatchFootball?>?) {
                    response?.let {
                        if (it.isSuccessful) {
                            callback.onDataLoadedFootballMatch(it.body())
                        }
                        else {
                            callback.onDataErrorFootballMatch()
                        }
                    }
                }
            })
    }

    fun getNextMatch(id: String, callback: MatchRepositoryCallbackFootballMatch<MatchFootball?>) {
        MyRetrofit
            .createService(ApiInterface::class.java)
            .getNextMatch(id)
            .enqueue(object : Callback<MatchFootball?> {
                override fun onFailure(call: Call<MatchFootball?>?, t: Throwable?) {
                    callback.onDataErrorFootballMatch()
                }

                override fun onResponse(call: Call<MatchFootball?>?, response: Response<MatchFootball?>?) {
                    response?.let {
                        if (it.isSuccessful) {
                            callback.onDataLoadedFootballMatch(it.body())
                        }
                        else {
                            callback.onDataErrorFootballMatch()
                        }
                    }
                }
            })
    }

    fun getSearchMatch(keyword: String, callback: MatchRepositoryCallbackFootballMatch<SearchMatchFootball?>) {
        MyRetrofit
            .createService(ApiInterface::class.java)
            .getSearchFootballMatch(keyword)
            .enqueue(object : Callback<SearchMatchFootball?> {
                override fun onFailure(call: Call<SearchMatchFootball?>?, t: Throwable?) {
                    callback.onDataErrorFootballMatch()
                }

                override fun onResponse(call: Call<SearchMatchFootball?>?, response: Response<SearchMatchFootball?>?) {
                    response?.let {
                        if (it.isSuccessful) {
                            callback.onDataLoadedFootballMatch(it.body())
                        }
                        else {
                            callback.onDataErrorFootballMatch()
                        }
                    }
                }
            })
    }
}