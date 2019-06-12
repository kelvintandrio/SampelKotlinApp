package com.tsmid.kelvinht.footballleague.presenter

import com.tsmid.kelvinht.footballleague.api.MatchRepository
import com.tsmid.kelvinht.footballleague.api.MatchRepositoryCallbackFootballMatch
import com.tsmid.kelvinht.footballleague.inter.IFootballMatchFragment
import com.tsmid.kelvinht.footballleague.inter.IFootballMatchPresenter
import com.tsmid.kelvinht.footballleague.model.MatchFootball

class NextMatchPresenter (private var nextMatchFragment: IFootballMatchFragment,
                          private val matchRepository: MatchRepository) : IFootballMatchPresenter {

    override fun getMatch(id : String) {
        matchRepository.getNextMatch(id, object : MatchRepositoryCallbackFootballMatch<MatchFootball?> {
            override fun onDataLoadedFootballMatch(data: MatchFootball?) {
                nextMatchFragment.setDataMatch(data)
                nextMatchFragment.successAccess()
            }

            override fun onDataErrorFootballMatch() {
                nextMatchFragment.failedAccess()
            }

        })
    }

}