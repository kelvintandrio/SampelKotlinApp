package com.tsmid.kelvinht.footballleague.api

interface MatchRepositoryCallback<T> {
    fun onDataLoaded(data: T?)
    fun onDataError()

    // function for data Detail Football
    fun getNameFootball(name : String?)
    fun getLogoFootball(logo : String?)
    fun getYearFootball(year : String?)
    fun getCountryFootball(country : String?)
    fun getWebsiteFootball(website : String?)
}