package com.tsmid.kelvinht.footballleague.presenter

import com.tsmid.kelvinht.footballleague.R
import com.tsmid.kelvinht.footballleague.inter.IMainActivity
import com.tsmid.kelvinht.footballleague.model.Football
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.*

class MainPresenterTest {

    @Mock
    private lateinit var view: IMainActivity

    private lateinit var presenter: MainPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = MainPresenter(view)
    }

    @Test
    fun getDataFootball() {
        val list: ArrayList<Football> = arrayListOf()
        list.add(Football("4346","American Mayor League", R.drawable.img_american_mayor_league))
        Assert.assertEquals(Arrays.asList(Football("4346", "American Mayor League", R.drawable.img_american_mayor_league)), list)
        Assert.assertEquals("4346", list[0].idFootball)
        Assert.assertEquals("American Mayor League", list[0].titleFootball)
        Assert.assertEquals(R.drawable.img_american_mayor_league, list[0].logoFootball)
    }

    @Test
    fun goToFootballFavoritePage() {
        val message = "Anda Masuk Halaman Football Favorite"
        presenter.goToFootballFavoritePage()
        Mockito.verify(view).onToFootballFavoritePage(message)
    }
}