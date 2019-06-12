package com.tsmid.kelvinht.footballleague.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.tsmid.kelvinht.footballleague.R
import com.tsmid.kelvinht.footballleague.adapter.AdapterMatch
import com.tsmid.kelvinht.footballleague.api.MatchRepository
import com.tsmid.kelvinht.footballleague.inter.IFootballMatchFragment
import com.tsmid.kelvinht.footballleague.inter.IFootballMatchPresenter
import com.tsmid.kelvinht.footballleague.model.MatchFootball
import com.tsmid.kelvinht.footballleague.presenter.PreviousMatchPresenter
import kotlinx.android.synthetic.main.fragment_previous_match.*
import org.jetbrains.anko.support.v4.toast

class PreviousMatchFragment: Fragment(), IFootballMatchFragment {

    private lateinit var previousMatchFragment: IFootballMatchPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_previous_match, container, false)

        previousMatchFragment = PreviousMatchPresenter(this, MatchRepository())
        previousMatchFragment.getMatch("4346")
//        arguments?.getString("ID_MATCH")?.let {
//            previousMatchFragment.getMatch(it)
//        }

        return view
    }

    override fun setDataMatch(dataMatch: MatchFootball?) {
        rv_football_previous_match.apply {
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
            adapter?.notifyDataSetChanged()
            adapter = AdapterMatch(dataMatch, activity)
        }
    }

    override fun successAccess() {
        toast("Sukses Akses Data Previous Match")
    }

    override fun failedAccess() {
        toast("Gagal Akses Data Previous Match")
    }

}
