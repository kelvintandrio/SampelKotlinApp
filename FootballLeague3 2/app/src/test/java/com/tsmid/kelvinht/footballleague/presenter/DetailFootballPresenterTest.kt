package com.tsmid.kelvinht.footballleague.presenter

import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.eq
import com.tsmid.kelvinht.footballleague.api.MatchRepository
import com.tsmid.kelvinht.footballleague.api.MatchRepositoryCallback
import com.tsmid.kelvinht.footballleague.inter.IDetailFootballActivity
import com.tsmid.kelvinht.footballleague.model.MatchResponse
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

    @Mock
    private lateinit var matchResponse: MatchResponse

    private lateinit var presenter: DetailFootballPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = DetailFootballPresenter(view, matchRepository)
    }

    @Test
    fun getDetailFootball() {

        val id = "4346"
        presenter.getDetailFootball(id)

        argumentCaptor<MatchRepositoryCallback<MatchResponse?>>().apply {
            verify(matchRepository).getDetailMatch(eq(id), capture())
            firstValue.onDataLoaded(matchResponse)
        }

//        Mockito.verify(view).setTextNameFootball("American Major League Soccer")

//        Mockito.verify(view)

//        Mockito.verify(view).setTextNameFootball(nameLeague)
    }
}