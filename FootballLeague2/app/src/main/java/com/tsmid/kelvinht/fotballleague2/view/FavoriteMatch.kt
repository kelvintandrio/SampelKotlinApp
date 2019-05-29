package com.tsmid.kelvinht.fotballleague2.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.tsmid.kelvinht.fotballleague2.R
import com.tsmid.kelvinht.fotballleague2.adapter.AdapterFootballFavorite
import com.tsmid.kelvinht.fotballleague2.adapter.AdapterMatch
import com.tsmid.kelvinht.fotballleague2.db.FootballFavorite
import com.tsmid.kelvinht.fotballleague2.db.database
import com.tsmid.kelvinht.fotballleague2.model.FavoriteFootballMatch
import kotlinx.android.synthetic.main.activity_favorite_match.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

class FavoriteMatch : AppCompatActivity() {

    private var favorites: MutableList<FavoriteFootballMatch> = mutableListOf()
    private var adapter: AdapterMatch? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_match)

        showFavorite()

        rv_football_favorite_match.apply {
            layoutManager = LinearLayoutManager(this@FavoriteMatch)
            setHasFixedSize(true)
            adapter = AdapterFootballFavorite(favorites, this@FavoriteMatch)
        }
    }

    private fun showFavorite(){
        favorites.clear()
        database.use {
            val result = select(FootballFavorite.TABLE_FOOTBALL_FAVORITE)
            val favorite = result.parseList(classParser<FavoriteFootballMatch>())
            favorites.addAll(favorite)
            adapter?.notifyDataSetChanged()
        }
    }
}
