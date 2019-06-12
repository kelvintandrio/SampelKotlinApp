package com.tsmid.kelvinht.footballleague.presenter

import com.tsmid.kelvinht.footballleague.api.MatchRepository
import com.tsmid.kelvinht.footballleague.api.MatchRepositoryCallback
import com.tsmid.kelvinht.footballleague.api.MatchRepositoryCallbackFootballMatch
import com.tsmid.kelvinht.footballleague.inter.IDetailFootballActivity
import com.tsmid.kelvinht.footballleague.inter.IDetailFootballPresenter
import com.tsmid.kelvinht.footballleague.model.DetailFootball
import com.tsmid.kelvinht.footballleague.model.MatchFootball
import com.tsmid.kelvinht.footballleague.model.SearchMatchFootball

class DetailFootballPresenter(private var detailFootballActivity: IDetailFootballActivity,
                              private val matchRepository: MatchRepository) : IDetailFootballPresenter {

    override fun getDetailFootball(id : String) {
        matchRepository.getDetailMatch(id, object : MatchRepositoryCallback<DetailFootball?> {
            override fun onDataLoaded(data: DetailFootball?) {
                detailFootballActivity.successLoadData()
            }

            override fun onDataError() {
                detailFootballActivity.failedLoadData()
            }

            override fun getNameFootball(name: String?) {
                detailFootballActivity.setTextNameFootball(name)
            }
            override fun getLogoFootball(logo: String?) {
                detailFootballActivity.setImageLogoFootball(logo)
            }

            override fun getYearFootball(year: String?) {
                detailFootballActivity.setTextYearFootball(year)
            }

            override fun getCountryFootball(country: String?) {
                detailFootballActivity.setTextCountryFootball(country)
            }

            override fun getWebsiteFootball(website: String?) {
                detailFootballActivity.setTextWebsiteFootball(website)
            }
        })
    }

    override fun getSearchFootballMatch(keyword : String) {
        matchRepository.getSearchMatch(keyword, object : MatchRepositoryCallbackFootballMatch<SearchMatchFootball?> {
            override fun onDataLoadedFootballMatch(data: SearchMatchFootball?) {
                detailFootballActivity.successSearchData()
                detailFootballActivity.getDataSearchMatch(data)
            }

            override fun onDataErrorFootballMatch() {
                detailFootballActivity.failedSearchData()
            }

        })
    }
}