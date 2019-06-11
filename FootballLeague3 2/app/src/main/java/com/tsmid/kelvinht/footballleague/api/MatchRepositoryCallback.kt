package com.tsmid.kelvinht.footballleague.api

import com.tsmid.kelvinht.footballleague.model.DetailFootball

interface MatchRepositoryCallback<T> {
    fun onDataLoaded(data: DetailFootball?)
    fun getNameFootball(name : String?)
    fun onDataError()
}