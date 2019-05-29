package com.tsmid.kelvinht.fotballleague2.presenter

import com.tsmid.kelvinht.fotballleague2.R
import com.tsmid.kelvinht.fotballleague2.model.Football
import org.junit.Assert
import org.junit.Test
import java.util.*

class FootballPresenterTest {

    @Test
    fun getDataFootball() {
        val list: ArrayList<Football> = arrayListOf()
        list.add(Football("4346","American Mayor League", R.drawable.img_american_mayor_league))
        Assert.assertEquals(Arrays.asList(Football("4346", "American Mayor League", R.drawable.img_american_mayor_league)), list)
    }
}