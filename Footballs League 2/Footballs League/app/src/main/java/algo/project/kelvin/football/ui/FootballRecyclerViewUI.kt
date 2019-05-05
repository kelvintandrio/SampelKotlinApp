package algo.project.kelvin.football.ui

import algo.project.kelvin.football.R
import android.graphics.Color
import android.support.v4.content.res.ResourcesCompat
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*

class FootballRecyclerViewUI : AnkoComponent<ViewGroup> {
    companion object {
        val TitleFootball = 1
        val LogoFootball = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout {
            // This is desain UI for component VerticalLayout
            lparams(matchParent, wrapContent) {
                margin = dip(16)
            }
            background = ResourcesCompat.getDrawable(resources, R.drawable.rounded_yellow, null)

            imageView {
                id = LogoFootball
                setImageResource(id)
                layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent)
            }

            textView {
                id = TitleFootball
                layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent)
                textAlignment = View.TEXT_ALIGNMENT_CENTER
                textColor = Color.BLACK
                textSize = 20f
            }
        }
    }
}
