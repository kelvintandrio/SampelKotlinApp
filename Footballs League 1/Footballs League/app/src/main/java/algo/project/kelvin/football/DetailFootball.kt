package algo.project.kelvin.football

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.*

class DetailFootball : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_football)
        FootballDetailUI().setContentView(this)
    }

    class FootballDetailUI : AnkoComponent<DetailFootball> {
        override fun createView(ui: AnkoContext<DetailFootball>) = with(ui) {
            verticalLayout{
                padding = dip(16)

                verticalLayout {
                    imageView() {

                    }
                }.lparams(matchParent, matchParent) {
                    margin = dip(16)
                }
//                val name = editText {
//                    hint = "What's your name?"
//                }
//
//                button("Say Hello"){
//                    backgroundColor = ContextCompat.getColor(context, colorAccent)
//                    textColor = Color.WHITE
//                    setOnClickListener { toast("Hello, ${name.text}!") }
//                }.lparams(width = matchParent){
//                    topMargin = dip(5)
//                }
//
//                button("Show Alert"){
//                    backgroundColor = ContextCompat.getColor(context, colorAccent)
//                    textColor = Color.WHITE
//
//                    setOnClickListener {
//                        alert("Happy Coding!", "Hello, ${name.text}!") {
//                            yesButton { toast("Oh…") }
//                            noButton {}
//                        }.show()
//                    }
//                }.lparams(width = matchParent){
//                    topMargin = dip(5)
//                }
//
//                button("Show Selector"){
//                    backgroundColor = ContextCompat.getColor(context, colorAccent)
//                    textColor = Color.WHITE
//
//                    setOnClickListener {
//                        val club = listOf("Barcelona", "Real Madrid", "Bayern Munchen", "Liverpool")
//                        selector("Hello, ${name.text}! What's football club do you love?", club) { _, i ->
//                            toast("So you love ${club[i]}, right?")
//                        }
//                    }
//                }.lparams(width = matchParent){
//                    topMargin = dip(5)
//                }
//
//                button("Show Snackbar"){
//                    backgroundColor = ContextCompat.getColor(context, colorAccent)
//                    textColor = Color.WHITE
//
//                    setOnClickListener {
//                        snackbar("Hello, ${name.text}!")
//                    }
//                }.lparams(width = matchParent){
//                    topMargin = dip(5)
//                }
//
//                button("Go to Second Activity"){
//                    backgroundColor = ContextCompat.getColor(context, colorAccent)
//                    textColor = Color.WHITE
//
//                    setOnClickListener {
//                        startActivity<SecondActivity>("name" to "${name.text}")
//                    }
//                }.lparams(width = matchParent){
//                    topMargin = dip(5)
//                }
            }
        }
    }
}
