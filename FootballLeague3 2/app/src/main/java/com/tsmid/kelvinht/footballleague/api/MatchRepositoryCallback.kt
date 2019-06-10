package com.tsmid.kelvinht.footballleague.api

import com.tsmid.kelvinht.footballleague.model.MatchResponse

interface MatchRepositoryCallback<T> {
    fun onDataLoaded(data: T?)
    fun onDataError()
}