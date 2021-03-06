package com.tsmid.kelvinht.footballleague.presenter

import com.tsmid.kelvinht.footballleague.api.MatchRepository
import com.tsmid.kelvinht.footballleague.api.MatchRepositoryCallbackFootballMatch
import com.tsmid.kelvinht.footballleague.inter.IFootballMatchFragment
import com.tsmid.kelvinht.footballleague.inter.IFootballMatchPresenter
import com.tsmid.kelvinht.footballleague.model.MatchFootball

class PreviousMatchPresenter (private var previousMatchFragment: IFootballMatchFragment,
                              private val matchRepository: MatchRepository) : IFootballMatchPresenter {

    override fun getMatch(id : String) {
        matchRepository.getPreviousMatch(id, object : MatchRepositoryCallbackFootballMatch<MatchFootball?> {
            override fun onDataLoadedFootballMatch(data: MatchFootball?) {
                previousMatchFragment.setDataMatch(data)
                previousMatchFragment.successAccess()
            }

            override fun onDataErrorFootballMatch() {
                previousMatchFragment.failedAccess()
            }

        })
    }

}