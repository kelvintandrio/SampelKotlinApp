package com.tsmid.kelvinht.footballleague.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.squareup.picasso.Picasso
import com.tsmid.kelvinht.footballleague.R
import com.tsmid.kelvinht.footballleague.api.MatchRepository
import com.tsmid.kelvinht.footballleague.inter.IDetailFootballActivity
import com.tsmid.kelvinht.footballleague.inter.IDetailFootballPresenter
import com.tsmid.kelvinht.footballleague.presenter.DetailFootballPresenter
import kotlinx.android.synthetic.main.activity_detail_football.*

class DetailFootballActivity : AppCompatActivity(), IDetailFootballActivity {

    private lateinit var detailFootballPresenter: IDetailFootballPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_football)

        detailFootballPresenter = DetailFootballPresenter(this, MatchRepository())
        val tabLayout: TabLayout = findViewById(R.id.tab_layout)
        val viewPager: ViewPager = findViewById(R.id.view_pager)

        detailFootballPresenter.getDetailFootball(intent.getStringExtra("ID_FOOTBALL"))
    }

    @SuppressLint("SetTextI18n")
    override fun setTextNameFootball(name: String) {
        nameFootball.text = "Name : $name"
    }

    override fun setImageLogoFootball(logo: String) {
        logo.let {
            Picasso.get().load(it).into(logoFootball)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun setTextYearFootball(year: String) {
        yearFootball.text = "Year : $year"
    }

    @SuppressLint("SetTextI18n")
    override fun setTextCountryFootball(country: String) {
        countryFootball.text = "Country : $country"
    }

    @SuppressLint("SetTextI18n")
    override fun setTextWebsiteFootball(website: String) {
        websiteFootball.text = "Website : $website"
    }
}
