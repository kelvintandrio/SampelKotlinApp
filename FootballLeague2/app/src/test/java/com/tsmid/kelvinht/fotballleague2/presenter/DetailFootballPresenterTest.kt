package com.tsmid.kelvinht.fotballleague2.presenter

import com.tsmid.kelvinht.fotballleague2.retrofit.ApiInterface
import com.tsmid.kelvinht.fotballleague2.view.DetailFootball
import com.tsmid.kelvinht.fotballleague2.view.inter.IDetailFootball
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class DetailFootballPresenterTest {

    @Mock
    private lateinit var view: IDetailFootball

    @Mock
    private lateinit var apiRepository: ApiInterface

    @Mock
    private lateinit var apiResponse: Deferred<String>

    private lateinit var presenter: DetailFootballPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = DetailFootballPresenter(view)
    }

    @Test
    fun getDataObject() {
        val id = "4346"
        val code1 = 1 // For get data Detail Football
        val code2 = 2 // For get data Football Match from searchView
        val context = Mockito.mock(DetailFootball::class.java)

        runBlocking {
            Mockito.`when`(apiRepository.doRequest(ArgumentMatchers.anyString()))
                .thenReturn(apiResponse)
            Mockito.`when`(apiResponse.await()).thenReturn("")
            presenter.getDataObject(id, code1, context)
            presenter.getDataObject(id, code2, context)

            Mockito.verify(view)
        }
    }
}

