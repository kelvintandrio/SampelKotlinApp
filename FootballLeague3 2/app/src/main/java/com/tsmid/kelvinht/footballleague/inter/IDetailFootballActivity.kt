package com.tsmid.kelvinht.footballleague.inter

import com.tsmid.kelvinht.footballleague.api.MatchRepositoryCallback
import com.tsmid.kelvinht.footballleague.model.MatchResponse

interface IDetailFootballActivity : MatchRepositoryCallback<MatchResponse> {
    fun setTextNameFootball(name: String?)
    fun setImageLogoFootball(logo: String?)
    fun setTextYearFootball(year: String?)
    fun setTextCountryFootball(country: String?)
    fun setTextWebsiteFootball(website: String?)
    fun successLoadData()
    fun failedLoadData()
}