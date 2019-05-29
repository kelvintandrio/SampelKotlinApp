package com.tsmid.kelvinht.fotballleague2.view


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tsmid.kelvinht.fotballleague2.R
import com.tsmid.kelvinht.fotballleague2.adapter.AdapterMatch
import com.tsmid.kelvinht.fotballleague2.model.FootballMatch
import com.tsmid.kelvinht.fotballleague2.retrofit.ApiInterface
import kotlinx.android.synthetic.main.fragment_previous_match.*
import org.jetbrains.anko.support.v4.toast
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

class PreviousMatchFragment : Fragment() {

    private var listFootballPreviousMatch: ArrayList<FootballMatch> = arrayListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_previous_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getDataPreviousMatch()
    }

    private fun getDataPreviousMatch() {
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiInterface.JSONURL.url)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()

        val api = retrofit.create(ApiInterface::class.java)
        val call = api.getPreviousMatch("4346")

        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                //Toast.makeText()
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        val jsonresponse = response.body().toString()
                        val obj = JSONObject(jsonresponse)
                        if (obj.getString("events") != "null") {
                            val dataArray = obj.getJSONArray("events")
                            for (i in 0 until dataArray.length()) {
                                val dataobj = dataArray.getJSONObject(i)
                                val footballPreviousMatch = FootballMatch (
                                    dataobj.getString("idEvent"),
                                    dataobj.getString("strEvent"),
                                    dataobj.getString("strFilename"),
                                    dataobj.getString("strHomeTeam"),
                                    dataobj.getString("strAwayTeam"),
                                    dataobj.getString("intHomeScore"),
                                    dataobj.getString("intAwayScore")
                                )
                                listFootballPreviousMatch.add(footballPreviousMatch)
                            }
                            rv_football_previous_match.apply {
                                layoutManager = LinearLayoutManager(activity)
                                setHasFixedSize(true)
                                adapter?.notifyDataSetChanged()
                                adapter = AdapterMatch(listFootballPreviousMatch, activity)
                            }
                            toast("Ada Event Previous Match")
                        }
                        else {
                            toast("Tidak Ada Event Previous Match")
                        }
                        Log.i("hh","${listFootballPreviousMatch.size}")
                        //writeTv(jsonresponse)
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


}
