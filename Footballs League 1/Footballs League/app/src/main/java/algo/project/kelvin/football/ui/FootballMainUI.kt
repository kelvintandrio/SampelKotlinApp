package algo.project.kelvin.football.ui

import android.graphics.Color
import android.view.View
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
