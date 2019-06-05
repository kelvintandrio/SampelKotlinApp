package com.tsmid.kelvinht.footballleague.presenter

import android.util.Log
import com.tsmid.kelvinht.footballleague.api.MatchRepository
import com.tsmid.kelvinht.footballleague.api.MatchRepositoryCallback
import com.tsmid.kelvinht.footballleague.inter.IDetailFootballActivity
import com.tsmid.kelvinht.footballleague.inter.IDetailFootballPresenter
import org.json.JSONObject

class DetailFootballPresenter(private var detailFootballActivity: IDetailFootballActivity,
                              private val matchRepository: MatchRepository) : IDetailFootballPresenter {

    override fun getDetailFootball(id : String) {
        matchRepository.getDetailMatch(id, object : MatchRepositoryCallback<String?> {
            override fun onDataLoaded(data: String?) {
                Log.i("onSuccess", data.toString())
                val jsonResponse = data.toString()
                val obj = JSONObject(jsonResponse)
                val dataArray = obj.getJSONArray("leagues")
                val dataObject = dataArray.getJSONObject(0)

                detailFootballActivity.setTextNameFootball(dataObject.getString("strLeague"))
                detailFootballActivity.setImageLogoFootball(dataObject.getString("strLogo"))
                detailFootballActivity.setTextYearFootball(dataObject.getString("intFormedYear"))
                detailFootballActivity.setTextCountryFootball(dataObject.getString("strCountry"))
                detailFootballActivity.setTextWebsiteFootball(dataObject.getString("strWebsite"))
            }

            override fun onDataError() {
                Log.i("Gagal","Response Gagal")
            }
        })
    }
}