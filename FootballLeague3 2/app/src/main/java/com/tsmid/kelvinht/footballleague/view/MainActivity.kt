package com.tsmid.kelvinht.footballleague.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.tsmid.kelvinht.footballleague.R
import com.tsmid.kelvinht.footballleague.adapter.AdapterFootball
import com.tsmid.kelvinht.footballleague.inter.IMainActivity
import com.tsmid.kelvinht.footballleague.inter.IMainPresenter
import com.tsmid.kelvinht.footballleague.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), IMainActivity {

    private lateinit var mainPresenter: IMainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter = MainPresenter(this)

        rv_football.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            setHasFixedSize(true)
            adapter?.notifyDataSetChanged()
            adapter = AdapterFootball(mainPresenter.getDataFootball(), this@MainActivity)
        }

        toPageFavoriteFootball.setOnClickListener {
            mainPresenter.goToFootballFavoritePage()
        }
    }

    override fun onToFootballFavoritePage(message: String) {
        toast(message)
        startActivity<FootballFavoriteActivity>()
    }
}
