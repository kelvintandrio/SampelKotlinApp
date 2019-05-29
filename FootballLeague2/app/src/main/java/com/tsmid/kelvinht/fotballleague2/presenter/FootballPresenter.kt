package com.tsmid.kelvinht.fotballleague2.presenter

import android.content.Context
import com.tsmid.kelvinht.fotballleague2.R
import com.tsmid.kelvinht.fotballleague2.model.Football
import com.tsmid.kelvinht.fotballleague2.presenter.inter.IFootballPresenter
import com.tsmid.kelvinht.fotballleague2.view.FavoriteMatch
import com.tsmid.kelvinht.fotballleague2.view.inter.IMainView
import org.jetbrains.anko.startActivity

class FootballPresenter(private var mainView : IMainView) : IFootballPresenter {

    override fun getDataFootball(): ArrayList<Football> {
        val list: ArrayList<Football> = arrayListOf()
        list.add(Football("4346","American Mayor League",R.drawable.img_american_mayor_league))
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

    override fun goToFavoriteFootball(context: Context) {
        context.startActivity<FavoriteMatch>()
        mainView.onToPageFavoriteFootball()
    }
}