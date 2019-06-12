package com.tsmid.kelvinht.footballleague.inter

import com.tsmid.kelvinht.footballleague.model.MatchFootball
import com.tsmid.kelvinht.footballleague.model.SearchMatchFootball

interface IDetailFootballActivity {
    fun setTextNameFootball(name: String?)
    fun setImageLogoFootball(logo: String?)
    fun setTextYearFootball(year: String?)
    fun setTextCountryFootball(country: String?)
    fun setTextWebsiteFootball(website: String?)
    fun successLoadData()
    fun failedLoadData()
    fun getDataSearchMatch(dataMatch: SearchMatchFootball?)
    fun successSearchData()
    fun failedSearchData()
}