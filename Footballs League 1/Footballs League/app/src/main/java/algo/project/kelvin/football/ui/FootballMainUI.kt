package algo.project.kelvin.football.ui

import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*

class FootballMainUI : AnkoComponent<ViewGroup> {
    companion object {
        val TitleFootball = 1
        val LogoFootball = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout {
            // This is desain UI for component VerticalLayout
            lparams(matchParent, wrapContent)
            padding = dip(16)

//            imageView {
//                id = LogoFootball
//                setImageResource(id)
//                layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent)
//            }

            imageView(LogoFootball).lparams(dip(100), dip(100)) {
                margin = dip(16)
            }

//            textView {
//                id = LogoFootball
//                layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent)
//                text = "Sherlock"
//                textSize = 16f // <- it is sp, no worries
//                //textColor = Color.BLACK
//            }

            textView {
                id = TitleFootball
                layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent)
                text = "2009"
                textSize = 16f
            }

//            imageView(R.drawable.img_english_premier_league).lparams(matchParent, wrapContent) {
//                margin = dip(16);
//            }
        }
    }
}
