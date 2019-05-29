package com.tsmid.kelvinht.footballleague.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import com.tsmid.kelvinht.footballleague.R
import com.tsmid.kelvinht.footballleague.inter.IDetailFootballActivity
import com.tsmid.kelvinht.footballleague.inter.IDetailFootballPresenter
import com.tsmid.kelvinht.footballleague.presenter.DetailFootballPresenter

class DetailFootballActivity : AppCompatActivity(), IDetailFootballActivity {

    private lateinit var detailFootballPresenter: IDetailFootballPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_football)

        detailFootballPresenter = DetailFootballPresenter(this)
        val tabLayout: TabLayout = findViewById(R.id.tab_layout)
        val viewPager: ViewPager = findViewById(R.id.view_pager)

        detailFootballPresenter.getDetailFootball(intent.getStringExtra("ID_FOOTBALL"))
    }
}
