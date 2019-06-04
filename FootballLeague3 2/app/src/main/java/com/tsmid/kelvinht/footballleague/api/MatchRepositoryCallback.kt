package com.tsmid.kelvinht.footballleague.api

interface MatchRepositoryCallback<T> {
    fun onDataLoaded(data: T?)
    fun onDataError()
}