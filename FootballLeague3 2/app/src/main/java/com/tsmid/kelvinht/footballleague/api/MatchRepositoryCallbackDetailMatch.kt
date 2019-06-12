package com.tsmid.kelvinht.footballleague.api

interface MatchRepositoryCallbackDetailMatch<T> {
    fun onDataLoadedDetailMatch(data: T?)
    fun onDataErrorDetailMatch()
}