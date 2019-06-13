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
import com.tsmid.kelvinht.footballleague.presenter.NextMatchPresenter
import kotlinx.android.synthetic.main.fragment_next_match.*
import org.jetbrains.anko.support.v4.toast

class NextMatchFragment : Fragment(), IFootballMatchFragment {

    private lateinit var nextMatchFragment: IFootballMatchPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val View = inflater.inflate(R.layout.fragment_next_match, container, false)

        nextMatchFragment = NextMatchPresenter(this, MatchRepository())
//        nextMatchFragment.getMatch("4346")
        arguments?.getString("ID_MATCH")?.let {
            nextMatchFragment.getMatch(it)
        }

        return View
    }

    override fun setDataMatch(dataMatch: MatchFootball?) {
        rv_football_next_match.apply {
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
            adapter?.notifyDataSetChanged()
            adapter = AdapterMatch(dataMatch, activity)
        }
    }

    override fun successAccess() {
        toast("Sukses Akses Data Next Match")
    }

    override fun failedAccess() {
        toast("Gagal Akses Data Next Match")
    }


}
