package com.tsmid.kelvinht.footballleague.presenter

import com.tsmid.kelvinht.footballleague.api.MatchRepository
import com.tsmid.kelvinht.footballleague.api.MatchRepositoryCallback
import com.tsmid.kelvinht.footballleague.inter.IDetailFootballActivity
import com.tsmid.kelvinht.footballleague.inter.IDetailFootballPresenter
import com.tsmid.kelvinht.footballleague.model.DetailFootball

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
        })
    }
}