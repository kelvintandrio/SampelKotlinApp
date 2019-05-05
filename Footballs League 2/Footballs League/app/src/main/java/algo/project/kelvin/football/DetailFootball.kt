package algo.project.kelvin.football

import algo.project.kelvin.football.adapter.PageAdapter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import algo.project.kelvin.football.retrofit.ApiInterface
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.Retrofit
import retrofit2.Response
import org.json.JSONException
import org.json.JSONObject
import android.annotation.SuppressLint
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Picasso

class DetailFootball : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_football)

        getResponse()

//        initToolbar()
        val tabLayout: TabLayout = findViewById(R.id.tab_layout)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        val adapter = PageAdapter(supportFragmentManager)

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
    }

    private fun getResponse() {
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiInterface.JSONURL.url)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()

        val api = retrofit.create(ApiInterface::class.java)
        val call = api.getFootballDetail(4334.toString())

        Log.i("GETIDFOOTBALL", intent.getStringExtra("ID_FOOTBALL"))

        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                //Toast.makeText()
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        Log.i("onSuccess", response.body().toString())
                        val jsonresponse = response.body().toString()
                        writeTv(jsonresponse)
                    } else {
                        Log.i("onEmptyResponse", "Returned empty response")
                    }
                }
            }

            @SuppressLint("ShowToast")
            override fun onFailure(call: Call<String>, t: Throwable) {
                Toast.makeText(this@DetailFootball,"Gagal karena "+t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    @SuppressLint("SetTextI18n")
    private fun writeTv(response:String) {
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
            val descriptionFootball = findViewById<TextView>(R.id.descriptionFootball)

            nameFootball.text = "Name :\n"+dataobj.getString("strLeague")
            dataobj.getString("strLogo").let {
                Picasso.get().load(it).into(logoFootball)
            }
            yearFootball.text = "Year :\n"+dataobj.getString("intFormedYear")
            countryFootball.text = "Country : \n"+dataobj.getString("strCountry")
            webFootball.text = "Website :\n"+dataobj.getString("strWebsite")
            fbFootball.text = "Facebook :\n"+dataobj.getString("strFacebook")
            descriptionFootball.text = dataobj.getString("strDescriptionEN")
        }
        catch (e:JSONException) {
            e.printStackTrace()
        }
    }

//    private fun initToolbar() {
//        val toolbar: Toolbar = findViewById(R.id.toolbar)
//        setSupportActionBar(toolbar)
//    }
}
