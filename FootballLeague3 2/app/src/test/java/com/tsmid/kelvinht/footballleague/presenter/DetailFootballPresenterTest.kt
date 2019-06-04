package com.tsmid.kelvinht.footballleague.presenter

import com.tsmid.kelvinht.footballleague.inter.IDetailFootballActivity
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class DetailFootballPresenterTest {

    @Mock
    private lateinit var view: IDetailFootballActivity

    private lateinit var presenter: DetailFootballPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = DetailFootballPresenter(view)
    }

    @Test
    fun getDetailFootball() {
        val idLeague = "4346"
        val nameLeague = "American Major League"
        val logoLeague = "https://www.thesportsdb.com/images/media/league/logo/yrxxpx1421700436.png"
        val yearLeague = "1993"
        val countryLeague = "USA"
        val websiteLeague = "www.mlssoccer.com"

        presenter.getDetailFootball(idLeague)

        Mockito.verify(view).setTextNameFootball(nameLeague)
        Mockito.verify(view).setImageLogoFootball(logoLeague)
        Mockito.verify(view).setTextYearFootball(yearLeague)
        Mockito.verify(view).setTextCountryFootball(countryLeague)
        Mockito.verify(view).setTextWebsiteFootball(websiteLeague)
    }
}