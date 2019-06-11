package com.tsmid.kelvinht.footballleague.inter

import com.tsmid.kelvinht.footballleague.api.MatchRepositoryCallback
import com.tsmid.kelvinht.footballleague.model.DetailFootball

interface IDetailFootballActivity : MatchRepositoryCallback<DetailFootball> {
    fun setTextNameFootball(name: String?)
    fun setImageLogoFootball(logo: String?)
    fun setTextYearFootball(year: String?)
    fun setTextCountryFootball(country: String?)
    fun setTextWebsiteFootball(website: String?)
    fun successLoadData()
    fun failedLoadData()
}