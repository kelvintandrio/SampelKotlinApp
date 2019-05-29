package com.tsmid.kelvinht.fotballleague2.view

import android.annotation.SuppressLint
import android.content.Intent
import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.KeyEvent
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.tsmid.kelvinht.fotballleague2.R
import com.tsmid.kelvinht.fotballleague2.db.FootballFavorite
import com.tsmid.kelvinht.fotballleague2.db.database
import com.tsmid.kelvinht.fotballleague2.model.FootballDetail
import com.tsmid.kelvinht.fotballleague2.retrofit.ApiInterface
import kotlinx.android.synthetic.main.activity_detail_match.*
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.toast
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.text.SimpleDateFormat
import java.util.*

@Suppress("DEPRECATION")
class DetailMatch : AppCompatActivity() {

    private var listFootballDetailMatch: ArrayList<FootballDetail> = arrayListOf()

    private lateinit var nameMatch: TextView
    private lateinit var filenameMatch: TextView
    private lateinit var score: TextView
    private lateinit var nameTeam1: TextView
    private lateinit var nameTeam2: TextView

    private lateinit var tvNameMatch2: TextView
    private lateinit var tvFilenameMatch2: TextView
    private lateinit var tvLogoMatch: ImageView
    private lateinit var tvRoundMatch: TextView
    private lateinit var tvDateMatch: TextView

    private lateinit var tvNameTeam1: TextView
    private lateinit var tvNameTeam2: TextView
    private lateinit var tvScoreTeam1: TextView
    private lateinit var tvScoreTeam2: TextView
    private lateinit var tvShotTeam1: TextView
    private lateinit var tvShotTeam2: TextView
    private lateinit var tvFormationTeam1: TextView
    private lateinit var tvFormationTeam2: TextView
    private lateinit var tvGoalDetailTeam1: TextView
    private lateinit var tvGoalDetailTeam2: TextView
    private lateinit var tvYellowCardTeam1: TextView
    private lateinit var tvYellowCardTeam2: TextView
    private lateinit var tvRedCardTeam1: TextView
    private lateinit var tvRedCardTeam2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)

        nameMatch = findViewById(R.id.nameMatch)
        filenameMatch = findViewById(R.id.nameFileMatch)
        score = findViewById(R.id.skorMatch)
        nameTeam1 = findViewById(R.id.nameTim1)
        nameTeam2 = findViewById(R.id.nameTim2)

        tvNameMatch2 = findViewById(R.id.nameDetailMatch)
        tvFilenameMatch2 = findViewById(R.id.nameDetailFileMatch)
        tvLogoMatch = findViewById(R.id.logoDetailMatch)
        tvRoundMatch = findViewById(R.id.roundDetailMatch)
        tvDateMatch = findViewById(R.id.dateDetailMatch)

        tvNameTeam1 = findViewById(R.id.nameTeam1)
        tvNameTeam2 = findViewById(R.id.nameTeam2)
        tvScoreTeam1 = findViewById(R.id.scoreTeam1)
        tvScoreTeam2 = findViewById(R.id.scoreTeam2)
        tvShotTeam1 = findViewById(R.id.shotTeam1)
        tvShotTeam2 = findViewById(R.id.shotTeam2)
        tvFormationTeam1 = findViewById(R.id.formationTeam1)
        tvFormationTeam2 = findViewById(R.id.formationTeam2)
        tvGoalDetailTeam1 = findViewById(R.id.goalDetailTeam1)
        tvGoalDetailTeam2 = findViewById(R.id.goalTeam2)
        tvYellowCardTeam1 = findViewById(R.id.yelloCardTeam1)
        tvYellowCardTeam2 = findViewById(R.id.yelloCardTeam2)
        tvRedCardTeam1 = findViewById(R.id.redCardTeam1)
        tvRedCardTeam2 = findViewById(R.id.redCardTeam2)

        getDetailMatch()

        val status = intent.getStringExtra("STATUS")
        if (status == "1") {
            add_to_favorite.setImageDrawable(resources.getDrawable(R.drawable.ic_added_to_favorite))
        } else if (status == "0") {
            add_to_favorite.setImageDrawable(resources.getDrawable(R.drawable.ic_add_to_favorite))
        }
        add_to_favorite.setOnClickListener {
            if (status == "1") {
                add_to_favorite.setImageDrawable(resources.getDrawable(R.drawable.ic_add_to_favorite))
                removeFromFavorite()
            } else if (status == "0") {
                if (listFootballDetailMatch.size == 0) {
                    toast("Tunggu Loading Data Selesai")
                } else {
                    add_to_favorite.setImageDrawable(resources.getDrawable(R.drawable.ic_added_to_favorite))
                    addToFavorite()
                }
            }
        }
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK)
            startActivity(Intent(this, FavoriteMatch::class.java))
        return super.onKeyUp(keyCode, event)
    }

    private fun getDetailMatch() {
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiInterface.JSONURL.url)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()

        val api = retrofit.create(ApiInterface::class.java)
        val call = api.getDetailMatch(intent.getStringExtra("ID_FOOTBALL_EVENT"))

        call.enqueue(object : Callback<String> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<String>, response: Response<String>) {
                //Toast.makeText()
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        Log.i("onSuccess", response.body().toString())
                        val jsonresponse = response.body().toString()
                        val obj = JSONObject(jsonresponse)
                        val dataArray = obj.getJSONArray("events")

                        val dataobj = dataArray.getJSONObject(0)
                        val footballDetailMatch = FootballDetail(

                            dataobj.getString("strEvent"),
                            dataobj.getString("dateEvent"),
                            dataobj.getString("strTime"),
                            dataobj.getString("strFilename"),
                            dataobj.getString("strThumb"),
                            dataobj.getString("intRound"),

                            dataobj.getString("strHomeTeam"),
                            dataobj.getString("strAwayTeam"),
                            dataobj.getString("intHomeScore"),
                            dataobj.getString("intAwayScore"),
                            dataobj.getString("intHomeShots"),
                            dataobj.getString("intAwayShots"),
                            dataobj.getString("strHomeFormation"),
                            dataobj.getString("strAwayFormation"),
                            dataobj.getString("strHomeGoalDetails"),
                            dataobj.getString("strAwayGoalDetails"),
                            dataobj.getString("strHomeYellowCards"),
                            dataobj.getString("strAwayYellowCards"),
                            dataobj.getString("strHomeRedCards"),
                            dataobj.getString("strAwayRedCards")
                        )

                        Log.i("DATAFOOTBALL", dataobj.getString("strHomeTeam"))
                        listFootballDetailMatch.add(footballDetailMatch)
                        Log.i("KARTU KUNING", dataobj.getString("strAwayYellowCards"))

                        nameMatch.text = listFootballDetailMatch[0].nameEvent
                        filenameMatch.text = listFootballDetailMatch[0].nameFileEvent

                        if (listFootballDetailMatch[0].scoreTeam1 == "null" && listFootballDetailMatch[0].scoreTeam2 == "null")
                            score.text = "0:0"
                        else
                            score.text =
                                listFootballDetailMatch[0].scoreTeam1 + ":" + listFootballDetailMatch[0].scoreTeam2

                        nameTeam1.text = listFootballDetailMatch[0].nameTeam1
                        nameTeam2.text = listFootballDetailMatch[0].nameTeam2

                        tvNameMatch2.text = listFootballDetailMatch[0].nameEvent
                        tvFilenameMatch2.text = listFootballDetailMatch[0].nameFileEvent
                        listFootballDetailMatch[0].logoEvent.let { Picasso.get().load(it).into(tvLogoMatch) }
                        tvRoundMatch.text = "Round : " + listFootballDetailMatch[0].roundEvent
                        tvDateMatch.text =
                            "Date Time :\n" + getTimeGMT7(listFootballDetailMatch[0].dateEvent + " " + listFootballDetailMatch[0].timeEvent)

                        tvNameTeam1.text = listFootballDetailMatch[0].nameTeam1
                        tvNameTeam2.text = listFootballDetailMatch[0].nameTeam2

                        if (listFootballDetailMatch[0].scoreTeam1 == "null" && listFootballDetailMatch[0].scoreTeam2 == "null") {
                            tvScoreTeam1.text = "0"
                            tvScoreTeam2.text = "0"
                            tvShotTeam1.text = "0"
                            tvShotTeam2.text = "0"
                            tvFormationTeam1.text = "-"
                            tvFormationTeam2.text = "-"
                            tvGoalDetailTeam1.text = "-"
                            tvGoalDetailTeam2.text = "-"
                            tvYellowCardTeam1.text = "-"
                            tvYellowCardTeam2.text = "-"
                            tvRedCardTeam1.text = "-"
                            tvRedCardTeam2.text = "-"
                        } else {
                            tvScoreTeam1.text = listFootballDetailMatch[0].scoreTeam1
                            tvScoreTeam2.text = listFootballDetailMatch[0].scoreTeam2
                            tvShotTeam1.text = listFootballDetailMatch[0].shotTeam1
                            tvShotTeam2.text = listFootballDetailMatch[0].shotTeam2

                            if (listFootballDetailMatch[0].shotTeam1 == "null")
                                tvShotTeam1.text = "-"
                            else
                                tvShotTeam1.text = listFootballDetailMatch[0].shotTeam1

                            if (listFootballDetailMatch[0].shotTeam2 == "null")
                                tvShotTeam2.text = "-"
                            else
                                tvShotTeam2.text = listFootballDetailMatch[0].shotTeam2

                            if (listFootballDetailMatch[0].formationTeam1 == "null")
                                tvFormationTeam1.text = "-"
                            else
                                tvFormationTeam1.text = listFootballDetailMatch[0].formationTeam2

                            if (listFootballDetailMatch[0].formationTeam2 == "null")
                                tvFormationTeam2.text = "-"
                            else
                                tvFormationTeam2.text = listFootballDetailMatch[0].formationTeam2

                            if (listFootballDetailMatch[0].goalDetailTeam1 == "null")
                                tvGoalDetailTeam1.text = "-"
                            else
                                tvGoalDetailTeam1.text = listFootballDetailMatch[0].goalDetailTeam1

                            if (listFootballDetailMatch[0].goalDetailTeam2 == "null")
                                tvGoalDetailTeam2.text = "-"
                            else
                                tvGoalDetailTeam2.text = listFootballDetailMatch[0].goalDetailTeam2

                            if (listFootballDetailMatch[0].yellowCardTeam1 == "null")
                                tvYellowCardTeam1.text = "-"
                            else
                                tvYellowCardTeam1.text = listFootballDetailMatch[0].yellowCardTeam1

                            if (listFootballDetailMatch[0].yellowCardTeam2 == "null")
                                tvYellowCardTeam2.text = "-"
                            else
                                tvYellowCardTeam2.text = listFootballDetailMatch[0].yellowCardTeam2

                            if (listFootballDetailMatch[0].redCardTeam1 == "null")
                                tvRedCardTeam1.text = "-"
                            else
                                tvRedCardTeam1.text = listFootballDetailMatch[0].redCardTeam1

                            if (listFootballDetailMatch[0].redCardTeam2 == "null")
                                tvRedCardTeam2.text = "-"
                            else
                                tvRedCardTeam2.text = listFootballDetailMatch[0].redCardTeam2
                        }
                    } else {
                        Log.i("onEmptyResponse", "Returned empty response")
                    }
                }
            }

            @SuppressLint("ShowToast")
            override fun onFailure(call: Call<String>, t: Throwable) {
//                Toast.makeText(this@DetailFootball,"Gagal karena "+t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun getTimeGMT7(dateAsString: String): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        formatter.timeZone = TimeZone.getTimeZone("UTC")
        val result = formatter.parse(dateAsString)
        return result.toString()
    }

    private fun addToFavorite() {
        try {
            database.use {
                insert(
                    FootballFavorite.TABLE_FOOTBALL_FAVORITE,
                    FootballFavorite.ID_EVENT to intent.getStringExtra("ID_FOOTBALL_EVENT"),
                    FootballFavorite.TEAM_NAME to listFootballDetailMatch[0].nameEvent,
                    FootballFavorite.TEAM_NAME_FILE to listFootballDetailMatch[0].nameFileEvent,
                    FootballFavorite.SCORE_TEAM1 to listFootballDetailMatch[0].scoreTeam1,
                    FootballFavorite.SCORE_TEAM2 to listFootballDetailMatch[0].scoreTeam2,
                    FootballFavorite.NAME_TEAM1 to listFootballDetailMatch[0].nameTeam1,
                    FootballFavorite.NAME_TEAM2 to listFootballDetailMatch[0].nameTeam2
                )
            }
            toast("Pilihan Match Anda Sudah Masuk ke Favorite Football")
        } catch (e: SQLiteConstraintException) {
            toast("Gagal Masuk ke Favorite Football")
        }
    }

    private fun removeFromFavorite() {
        try {
            database.use {
                delete(
                    FootballFavorite.TABLE_FOOTBALL_FAVORITE, "(ID_EVENT = {id})",
                    "id" to intent.getStringExtra("ID_FOOTBALL_EVENT")
                )
            }
            toast("Anda Sudah Menghapus Event")
        } catch (e: SQLiteConstraintException) {
            toast("Gagal Menghapus Event")
        }
    }
}

    