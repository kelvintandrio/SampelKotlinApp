package algo.project.kelvin.football.page


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import algo.project.kelvin.football.R
import algo.project.kelvin.football.adapter.AdapterPreviousMatch
import algo.project.kelvin.football.model.FootballPreviousMatch
import android.support.v7.widget.RecyclerView
import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_previous_match.*
import org.jetbrains.anko.support.v4.ctx


class PreviousMatch : Fragment() {

    private val adapterPreviousMatch : AdapterPreviousMatch? = null
    private val listFootballPreviousMatch : ArrayList<FootballPreviousMatch>? = null
    var mcontext: Context? = null

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {

        val v : View = inflater.inflate(R.layout.fragment_previous_match, container, false)
//        mcontext = container?.context

        // Make ArrayList for Data Previous Match into to AdapterPreviousMatch


        // Make Data Previous Match in RecylerView
        rv_football_previous_match.apply {
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)

        }

        // Inflate the layout for this fragment
        return v
    }

    companion object {
        fun newInstance(): PreviousMatch = PreviousMatch()
    }

}
