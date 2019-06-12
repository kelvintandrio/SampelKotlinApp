package com.tsmid.kelvinht.footballleague.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class PageAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private val fragments: MutableList<Fragment> = mutableListOf()
    private val listTitle: MutableList<String> = mutableListOf()

    override fun getItem(position: Int): Fragment = fragments[position]
    override fun getCount(): Int = fragments.size

    fun addFragmentWithTitle(fragment: Fragment, title: String) {
        fragments.add(fragment)
        listTitle.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? = listTitle[position]

}