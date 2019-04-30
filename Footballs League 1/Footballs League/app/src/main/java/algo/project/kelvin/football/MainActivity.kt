package algo.project.kelvin.football

import algo.project.kelvin.football.adapter.AdapterFootball
import algo.project.kelvin.football.model.Football
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val list: ArrayList<Football> = arrayListOf()
        list.add(Football("American Mayor League",R.drawable.img_american_mayor_league))
        list.add(Football("Australian League",R.drawable.img_australian_a_league))
        list.add(Football("English League",R.drawable.img_english_league_1))
        list.add(Football("English Premier League", R.drawable.img_english_premier_league))
        list.add(Football("French Ligue", R.drawable.img_french_ligue_1))
        list.add(Football("German Bundesliga",R.drawable.img_german_bundesliga))
        list.add(Football("Italian Serie A",R.drawable.img_italian_serie_a))
        list.add(Football("Portugeuese Premiera Liga",R.drawable.img_portugeuese_premiera_liga))
        list.add(Football("Scotish Premier League", R.drawable.img_scotish_premier_league))
        list.add(Football("Spanish La Liga", R.drawable.img_spanish_la_liga))

        recyclerView.adapter = AdapterFootball(list)
    }
}