package algo.project.kelvin.football

import algo.project.kelvin.football.adapter.AdapterFootball
import algo.project.kelvin.football.model.Football
import algo.project.kelvin.football.ui.FootballMainUI
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*
            Make ArrayList for Data Football with attribute : Name, Logo, and Description Football
            And this arraylist into to AdapterFootball for display data in Recylerview
        */
        val list: ArrayList<Football> = arrayListOf()
        list.add(Football("4328","American Mayor League",R.drawable.img_american_mayor_league))
        list.add(Football("4334","Australian League",R.drawable.img_australian_a_league))
        list.add(Football("4331","English League",R.drawable.img_english_league_1))
        list.add(Football("4332","English Premier League", R.drawable.img_english_premier_league))
        list.add(Football("4335","French Ligue", R.drawable.img_french_ligue_1))
        list.add(Football("4346","German Bundesliga",R.drawable.img_german_bundesliga))
        list.add(Football("4344","Italian Serie A",R.drawable.img_italian_serie_a))
        list.add(Football("4356","Portugeuese Premiera Liga",R.drawable.img_portugeuese_premiera_liga))
        list.add(Football("4330","Scotish Premier League", R.drawable.img_scotish_premier_league))
        list.add(Football("4396","Spanish La Liga", R.drawable.img_spanish_la_liga))
        val adapter = AdapterFootball(list)

        //Go to FootballMainUI for display Layout Recylerview with Adapter
        FootballMainUI(adapter).setContentView(this)
    }
}