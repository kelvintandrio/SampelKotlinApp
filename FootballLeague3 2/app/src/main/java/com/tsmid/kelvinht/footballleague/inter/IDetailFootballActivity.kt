package com.tsmid.kelvinht.footballleague.inter

import com.tsmid.kelvinht.footballleague.api.MatchRepositoryCallback

interface IDetailFootballActivity : MatchRepositoryCallback<String> {
    fun setTextNameFootball(name: String)
    fun setImageLogoFootball(logo: String)
    fun setTextYearFootball(year: String)
    fun setTextCountryFootball(country: String)
    fun setTextWebsiteFootball(website: String)
}