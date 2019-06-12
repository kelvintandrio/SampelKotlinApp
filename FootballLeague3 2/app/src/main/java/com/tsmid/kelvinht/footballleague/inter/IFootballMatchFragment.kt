package com.tsmid.kelvinht.footballleague.inter

import com.tsmid.kelvinht.footballleague.model.MatchFootball

interface IFootballMatchFragment {
    fun setDataMatch(dataMatch: MatchFootball?)
    fun successAccess()
    fun failedAccess()
}