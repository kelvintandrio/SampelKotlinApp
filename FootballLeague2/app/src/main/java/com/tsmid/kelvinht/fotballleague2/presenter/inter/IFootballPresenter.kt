package com.tsmid.kelvinht.fotballleague2.presenter.inter

import android.content.Context
import com.tsmid.kelvinht.fotballleague2.model.Football

interface IFootballPresenter {
    fun getDataFootball(): ArrayList<Football>
    fun goToFavoriteFootball(context: Context)
}