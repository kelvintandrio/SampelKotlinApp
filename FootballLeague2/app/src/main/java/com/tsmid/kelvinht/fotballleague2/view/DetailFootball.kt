package com.tsmid.kelvinht.fotballleague2.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.tsmid.kelvinht.fotballleague2.R
import com.tsmid.kelvinht.fotballleague2.adapter.AdapterMatch
import com.tsmid.kelvinht.fotballleague2.adapter.PageAdapter
import com.tsmid.kelvinht.fotballleague2.model.FootballMatch
import com.tsmid.kelvinht.fotballleague2.presenter.DetailFootballPresenter
import com.tsmid.kelvinht.fotballleague2.presenter.inter.IDetailFootballPresenter
import com.tsmid.kelvinht.fotballleague2.view.inter.IDetailFootball
import kotlinx.android.synthetic.main.activity_detail_football.*
import org.jetbrains.anko.toast
import org.json.JSONException
import org.json.JSONObject

class DetailFootball : AppCompatActivity(), IDetailFootball {

    private var status = 0
    private lateinit var searchFootball: SearchView
    private var listFootballSearchMatch: ArrayList<FootballMatch> = arrayListOf()
    private lateinit var detailFootballPresenter: IDetailFootballPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_football)

        detailFootballPresenter = DetailFootballPresenter(this)
        id_page_search_football.visibility = View.GONE

        getResponse("4346", 1)

        val tabLayout: TabLayout = findViewById(R.id.tab_layout)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        val adapter = PageAdapter(supportFragmentManager)

        val nextMatch = NextMatchFragment()
        val prevMatch = PreviousMatchFragment()

        val bundleNext = Bundle()
        bundleNext.putString("ID_MATCH", intent.getStringExtra("ID_FOOTBALL"))
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

        searchFootball = findViewById(R.id.search_event_football)
        searchFootball.setOnQueryTextFocusChangeListener(object : SearchView.OnQueryTextListener,
            View.OnFocusChangeListener {
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                Log.i("SUBMIT", "Awal $status")
                if (status == 0) {
                    Log.i("SUBMIT", "SUBMIT ke 0")
                    id_page_search_football.visibility = View.VISIBLE
                    status = 1

                } else if (status == 1) {
                    Log.i("SUBMIT", "SUBMIT ke 1")
                    id_page_search_football.visibility = View.GONE
                    status = 0
                }
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        btnSearchFootball.setOnClickListener {
            getResponse(searchFootball.query.toString(), 2)
        }
    }

    private fun getResponse(keyword: String, code: Int) {
        val response = detailFootballPresenter.getDataObject(keyword, code, this)
        when (code) {
            1 -> getDataDescriptionFootball(response)
            2 -> getDataSearchFootballMatch(response)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun getDataDescriptionFootball(response: String) {
        try {
            //getting the whole json object from the response
            val obj = JSONObject(response)
            val dataArray = obj.getJSONArray("leagues")
            val dataobj = dataArray.getJSONObject(0)

            val nameFootball = findViewById<TextView>(R.id.nameFootball)
            val logoFootball = findViewById<ImageView>(R.id.logoFootball)
            val yearFootball = findViewById<TextView>(R.id.yearFootball)
            val countryFootball = findViewById<TextView>(R.id.countryFootball)
            val webFootball = findViewById<TextView>(R.id.websiteFootball)
            val fbFootball = findViewById<TextView>(R.id.facebookFootball)

            nameFootball.text = "Name :\n" + dataobj.getString("strLeague")
            dataobj.getString("strLogo").let {
                Picasso.get().load(it).into(logoFootball)
            }
            yearFootball.text = "Year :\n" + dataobj.getString("intFormedYear")
            countryFootball.text = "Country : \n" + dataobj.getString("strCountry")
            webFootball.text = "Website :\n" + dataobj.getString("strWebsite")
            fbFootball.text = "Facebook :\n" + dataobj.getString("strFacebook")
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    private fun getDataSearchFootballMatch(response: String) {
        val obj = JSONObject(response)
        val dataArray = obj.getJSONArray("event")

        if (dataArray.length() == 0) {
            detailFootballPresenter.statusSeaching("Data Match Yang Anda Cari Tidak Ada")
        }
        else {
            for (i in 0 until dataArray.length()) {
                val dataobj = dataArray.getJSONObject(i)
                val footballSearchMatch = FootballMatch(
                    dataobj.getString("idEvent"),
                    dataobj.getString("strEvent"),
                    dataobj.getString("strFilename"),
                    dataobj.getString("strHomeTeam"),
                    dataobj.getString("strAwayTeam"),
                    dataobj.getString("intHomeScore"),
                    dataobj.getString("intAwayScore")
                )
                listFootballSearchMatch.add(footballSearchMatch)
            }
            rv_football_search_match.apply {
                layoutManager = LinearLayoutManager(this@DetailFootball)
                setHasFixedSize(true)
                adapter?.notifyDataSetChanged()
                adapter = AdapterMatch(listFootballSearchMatch, this@DetailFootball)
            }
            detailFootballPresenter.statusSeaching("Data Match Yang Anda Cari Ada")
        }
    }

    override fun getStatusSearching(notice : String) {
        toast(notice)
    }
}
