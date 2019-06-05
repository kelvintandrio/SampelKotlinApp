package com.tsmid.kelvinht.footballleague.presenter

import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.eq
import com.tsmid.kelvinht.footballleague.api.MatchRepository
import com.tsmid.kelvinht.footballleague.api.MatchRepositoryCallback
import com.tsmid.kelvinht.footballleague.inter.IDetailFootballActivity
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class DetailFootballPresenterTest {

    @Mock
    private lateinit var view: IDetailFootballActivity

    @Mock
    private lateinit var matchRepository: MatchRepository

    private lateinit var presenter: DetailFootballPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = DetailFootballPresenter(view, matchRepository)
    }

    @Test
    fun getDetailFootball() {

        val id = "4346"
        val nameLeague = "American Major League"
        presenter.getDetailFootball(id)

        argumentCaptor<MatchRepositoryCallback<String?>>().apply {
            verify(matchRepository).getDetailMatch(eq(id), capture())
        }

        Mockito.verify(view).setTextNameFootball(nameLeague)
    }
}