package com.tsmid.kelvinht.footballleague.presenter

import com.tsmid.kelvinht.footballleague.R
import com.tsmid.kelvinht.footballleague.inter.IMainActivity
import com.tsmid.kelvinht.footballleague.inter.IMainPresenter
import com.tsmid.kelvinht.footballleague.model.Football

class MainPresenter(private var mainActivity : IMainActivity) : IMainPresenter  {

    override fun getDataFootball(): ArrayList<Football> {
        val list: ArrayList<Football> = arrayListOf()
        list.add(Football("4346","American Mayor League", R.drawable.img_american_mayor_league))
        list.add(Football("4356","Australian League",R.drawable.img_australian_a_league))
        list.add(Football("4396","English League",R.drawable.img_english_league_1))
        list.add(Football("4328","English Premier League", R.drawable.img_english_premier_league))
        list.add(Football("4334","French Ligue", R.drawable.img_french_ligue_1))
        list.add(Football("4331","German Bundesliga",R.drawable.img_german_bundesliga))
        list.add(Football("4332","Italian Serie A",R.drawable.img_italian_serie_a))
        list.add(Football("4344","Portugeuese Premiera Liga",R.drawable.img_portugeuese_premiera_liga))
        list.add(Football("4330","Scotish Premier League", R.drawable.img_scotish_premier_league))
        list.add(Football("4335","Spanish La Liga", R.drawable.img_spanish_la_liga))
        return list
    }

    override fun goToFootballFavoritePage() {
        mainActivity.onToFootballFavoritePage("Anda Masuk Halaman Football Favorite")
    }

}