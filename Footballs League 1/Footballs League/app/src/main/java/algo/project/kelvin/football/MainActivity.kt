package algo.project.kelvin.football

import algo.project.kelvin.football.adapter.AdapterFootball
import algo.project.kelvin.football.model.Football
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val list: ArrayList<Football> = arrayListOf()
        list.add(Football("American Mayor League",R.drawable.img_american_mayor_league))
        list.add(Football("Australian League",R.drawable.img_australian_a_league))
        list.add(Football("English League",R.drawable.img_english_league_1))
//        list.add(Football("Titanic",1997))
//        list.add(Football("Taxi",1998))
//        list.add(Football("Inception",1994))
//        list.add(Football("The Imitation Game",2014))

        recyclerView.adapter = AdapterFootball(list)
    }
}