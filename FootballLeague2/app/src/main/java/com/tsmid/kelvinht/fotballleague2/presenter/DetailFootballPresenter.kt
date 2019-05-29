package com.tsmid.kelvinht.fotballleague2.presenter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.tsmid.kelvinht.fotballleague2.presenter.inter.IDetailFootballPresenter
import com.tsmid.kelvinht.fotballleague2.retrofit.ApiInterface
import com.tsmid.kelvinht.fotballleague2.view.inter.IDetailFootball
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

class DetailFootballPresenter(private var detailFootball : IDetailFootball) : IDetailFootballPresenter {

    override fun getDataObject(keyword: String, code: Int, context: Context): String {
        var jsonresponse = ""
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiInterface.JSONURL.url)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
        val api = retrofit.create(ApiInterface::class.java)

        var call: Call<String>? = null
        if (code == 1) {
            call = api.getFootballDetail(keyword)
        } else if (code == 2) {
            call = api.getSearchFootballMatch(keyword)
        }

        call?.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        Log.i("onSuccess", response.body().toString())
                        jsonresponse = response.body().toString()
                    }
                    else {
                        Log.i("onEmptyResponse", "Returned empty response")
                    }
                }
            }

            @SuppressLint("ShowToast")
            override fun onFailure(call: Call<String>, t: Throwable) {
                Toast.makeText(context, "Gagal karena " + t.message, Toast.LENGTH_SHORT).show()
            }
        })
        return jsonresponse
    }

    override fun statusSeaching(notice : String) {
        detailFootball.getStatusSearching(notice)
    }
}