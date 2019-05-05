package algo.project.kelvin.football.ui

import algo.project.kelvin.football.MainActivity
import algo.project.kelvin.football.adapter.AdapterFootball
import android.support.v7.widget.GridLayoutManager
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class FootballMainUI(private val mAdapter: AdapterFootball) : AnkoComponent<MainActivity> {

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout {

            // This is section to make RecyclerView with Anko Layout
            recyclerView{
                lparams (width = matchParent, height = wrapContent) {
                    margin = dip(16)
                }
                layoutManager = GridLayoutManager(ctx, 2)
                adapter = mAdapter
            }
        }
    }
}