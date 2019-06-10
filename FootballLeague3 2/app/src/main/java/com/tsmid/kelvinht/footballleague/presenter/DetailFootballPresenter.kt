package com.tsmid.kelvinht.footballleague.presenter

import android.util.Log
import com.tsmid.kelvinht.footballleague.api.MatchRepository
import com.tsmid.kelvinht.footballleague.api.MatchRepositoryCallback
import com.tsmid.kelvinht.footballleague.inter.IDetailFootballActivity
import com.tsmid.kelvinht.footballleague.inter.IDetailFootballPresenter
import com.tsmid.kelvinht.footballleague.model.DetailFootball
import com.tsmid.kelvinht.footballleague.model.MatchResponse
import org.json.JSONObject

class DetailFootballPresenter(private var detailFootballActivity: IDetailFootballActivity,
                              private val matchRepository: MatchRepository) : IDetailFootballPresenter {

    override fun getDetailFootball(id : String) {
        matchRepository.getDetailMatch(id, object : MatchRepositoryCallback<MatchResponse?> {
            override fun onDataLoaded(data: MatchResponse?) {
                detailFootballActivity.successLoadData()
                detailFootballActivity.setTextNameFootball(data?.events?.get(0)?.nameFootball)
                detailFootballActivity.setImageLogoFootball(data?.events?.get(0)?.logoFootball)
                detailFootballActivity.setTextYearFootball(data?.events?.get(0)?.yearFootball)
                detailFootballActivity.setTextCountryFootball(data?.events?.get(0)?.countryFootball)
                detailFootballActivity.setTextWebsiteFootball(data?.events?.get(0)?.websiteFootball)
            }

            override fun onDataError() {
                detailFootballActivity.failedLoadData()
            }
        })
    }
}