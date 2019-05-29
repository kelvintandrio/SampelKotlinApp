package com.tsmid.kelvinht.fotballleague2.presenter.inter

import android.content.Context

interface IDetailFootballPresenter {
    fun getDataObject(keyword : String, code : Int, context: Context) : String
    fun statusSeaching(notice : String)
}