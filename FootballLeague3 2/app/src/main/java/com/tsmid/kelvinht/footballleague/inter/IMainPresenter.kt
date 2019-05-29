package com.tsmid.kelvinht.footballleague.inter

import com.tsmid.kelvinht.footballleague.model.Football

interface IMainPresenter {
    fun getDataFootball(): ArrayList<Football>
    fun goToFootballFavoritePage()
}