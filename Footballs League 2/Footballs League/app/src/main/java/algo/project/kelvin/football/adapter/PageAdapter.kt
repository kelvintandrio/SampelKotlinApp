package algo.project.kelvin.football.adapter

import algo.project.kelvin.football.page.NextMatch
import algo.project.kelvin.football.page.PreviousMatch
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class PageAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? = when (position) {
        0 -> PreviousMatch.newInstance()
        1 -> NextMatch.newInstance()
        else -> null
    }

    override fun getPageTitle(position: Int): CharSequence = when (position) {
        0 -> "Previous Match"
        1 -> "Next Match"
        else -> ""
    }

    override fun getCount(): Int = 2
}