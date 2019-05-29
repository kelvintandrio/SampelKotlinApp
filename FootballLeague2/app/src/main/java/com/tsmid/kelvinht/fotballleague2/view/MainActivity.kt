package com.tsmid.kelvinht.fotballleague2.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.tsmid.kelvinht.fotballleague2.R
import com.tsmid.kelvinht.fotballleague2.adapter.AdapterFootball
import com.tsmid.kelvinht.fotballleague2.presenter.FootballPresenter
import com.tsmid.kelvinht.fotballleague2.presenter.inter.IFootballPresenter
import com.tsmid.kelvinht.fotballleague2.view.inter.IMainView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), IMainView {

    private lateinit var footballPresenter: IFootballPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        footballPresenter = FootballPresenter(this)

        rv_football.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            setHasFixedSize(true)
            adapter?.notifyDataSetChanged()
            adapter = AdapterFootball(footballPresenter.getDataFootball(), this@MainActivity)
        }

        toPageFavoriteFootball.setOnClickListener {
            footballPresenter.goToFavoriteFootball(this)
        }
    }

    override fun onToPageFavoriteFootball() {
        toast("Anda masuk Favorite Football")
    }
}
