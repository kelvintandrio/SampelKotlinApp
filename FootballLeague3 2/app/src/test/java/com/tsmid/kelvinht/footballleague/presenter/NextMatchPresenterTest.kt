package com.tsmid.kelvinht.footballleague.presenter

import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.verify
import com.tsmid.kelvinht.footballleague.api.MatchRepository
import com.tsmid.kelvinht.footballleague.api.MatchRepositoryCallbackFootballMatch
import com.tsmid.kelvinht.footballleague.inter.IFootballMatchFragment
import com.tsmid.kelvinht.footballleague.model.MatchFootball
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class NextMatchPresenterTest {

    @Mock
    private lateinit var view: IFootballMatchFragment

    @Mock
    private lateinit var matchRepository: MatchRepository

    @Mock
    private lateinit var matchResponse: MatchFootball

    private lateinit var presenter: NextMatchPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = NextMatchPresenter(view, matchRepository)
    }

    @Test
    fun getSuccessNextMatch() {
        val id = "4346"
        presenter.getMatch(id)

        argumentCaptor<MatchRepositoryCallbackFootballMatch<MatchFootball?>>().apply {
            verify(matchRepository).getNextMatch(eq(id), capture())
            firstValue.onDataLoadedFootballMatch(matchResponse)
        }

        Mockito.verify(view).setDataMatch(matchResponse)
        Mockito.verify(view).successAccess()
    }

    @Test
    fun getFailedNextMatch() {

        presenter.getMatch("")

        argumentCaptor<MatchRepositoryCallbackFootballMatch<MatchFootball?>>().apply {
            verify(matchRepository).getNextMatch(eq(""), capture())
            firstValue.onDataErrorFootballMatch()
        }

        Mockito.verify(view).failedAccess()
    }
}