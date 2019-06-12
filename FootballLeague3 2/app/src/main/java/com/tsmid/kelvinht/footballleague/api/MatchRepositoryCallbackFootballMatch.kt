package com.tsmid.kelvinht.footballleague.api

interface MatchRepositoryCallbackFootballMatch<T> {
    fun onDataLoadedFootballMatch(data: T?)
    fun onDataErrorFootballMatch()
}