package com.tsmid.kelvinht.footballleague.view

import android.annotation.SuppressLint
import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.SearchView
import com.squareup.picasso.Picasso
import com.tsmid.kelvinht.footballleague.R
import com.tsmid.kelvinht.footballleague.adapter.AdapterMatch
import com.tsmid.kelvinht.footballleague.adapter.AdapterSearchMatch
import com.tsmid.kelvinht.footballleague.adapter.PageAdapter
import com.tsmid.kelvinht.footballleague.api.MatchRepository
import com.tsmid.kelvinht.footballleague.inter.IDetailFootballActivity
import com.tsmid.kelvinht.footballleague.inter.IDetailFootballPresenter
import com.tsmid.kelvinht.footballleague.model.MatchFootball
import com.tsmid.kelvinht.footballleague.model.SearchMatchFootball
import com.tsmid.kelvinht.footballleague.presenter.DetailFootballPresenter
import kotlinx.android.synthetic.main.activity_detail_football.*
import kotlinx.android.synthetic.main.fragment_previous_match.*
import org.jetbrains.anko.toast

class DetailFootballActivity : AppCompatActivity(), IDetailFootballActivity {

    private lateinit var detailFootballPresenter: IDetailFootballPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_football)

        // This is section to get data Details Football //
        detailFootballPresenter = DetailFootballPresenter(this, MatchRepository())
        detailFootballPresenter.getDetailFootball("4346")
//        detailFootballPresenter.getDetailFootball(intent.getStringExtra("ID_FOOTBALL"))
        // Ending for this section //

        // This is section to make TabLayout Previous Match and Next Match
        val tabLayout: TabLayout = findViewById(R.id.tab_layout)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        val adapter = PageAdapter(supportFragmentManager)

        val nextMatch = NextMatchFragment()
        val prevMatch = PreviousMatchFragment()

        val bundleNext = Bundle()
        bundleNext.putString("ID_MATCH", "4346")
//        bundleNext.putString("ID_MATCH", intent.getStringExtra("ID_FOOTBALL"))

        nextMatch.arguments = bundleNext
        prevMatch.arguments = bundleNext
        adapter.addFragmentWithTitle(nextMatch, "Next Match")
        adapter.addFragmentWithTitle(prevMatch, "Previous Match")

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {

            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
        // Ending for this section ///
    }

    // This is method to make SearchView in ViewMenu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)

        // Associate searchable configuration with the SearchView
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.search).actionView as SearchView

        searchView.apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }
        searchView.setOnSearchClickListener {
            Log.i("SEARCHVIEW","Search View Berjalan")
            id_page_search_football.visibility = View.VISIBLE
        }
        searchView.queryHint = "Cari"
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                Log.i("SearchString", "Anda input : $newText")
                return false
            }
            override fun onQueryTextSubmit(query: String): Boolean {
                Log.i("SearchSubmit", "Anda input : $query")
                detailFootballPresenter.getSearchFootballMatch(query)
                return false
            }

        })

        return true
    }
    // This is end method

    @SuppressLint("SetTextI18n")
    override fun setTextNameFootball(name: String?) {
        nameFootball.text = "Name : $name"
    }

    override fun setImageLogoFootball(logo: String?) {
        logo.let {
            Picasso.get().load(it).into(logoFootball)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun setTextYearFootball(year: String?) {
        yearFootball.text = "Year : $year"
    }

    @SuppressLint("SetTextI18n")
    override fun setTextCountryFootball(country: String?) {
        countryFootball.text = "Country : $country"
    }

    @SuppressLint("SetTextI18n")
    override fun setTextWebsiteFootball(website: String?) {
        websiteFootball.text = "Website : $website"
    }

    override fun successLoadData() {
        toast("Sukses Akses Data")
    }

    override fun failedLoadData() {
        toast("Gagal Akses Data")
    }

    override fun getDataSearchMatch(dataMatch: SearchMatchFootball?) {
        rv_football_search_match.apply {
            layoutManager = LinearLayoutManager(this@DetailFootballActivity)
            setHasFixedSize(true)
            adapter?.notifyDataSetChanged()
            adapter = AdapterSearchMatch(dataMatch, this@DetailFootballActivity)
        }
    }

    override fun successSearchData() {
        toast("Data Pencarian Match Berhasil")
    }

    override fun failedSearchData() {
        toast("Data Percarian Match Gagal")
    }

}
