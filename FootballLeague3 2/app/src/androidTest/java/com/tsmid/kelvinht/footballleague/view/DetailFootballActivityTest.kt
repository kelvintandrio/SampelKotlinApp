package com.tsmid.kelvinht.footballleague.view

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.tsmid.kelvinht.footballleague.R.id.*
import kotlinx.android.synthetic.main.fragment_previous_match.view.*
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DetailFootballActivityTest {
    @Rule
    @JvmField var activityRule = ActivityTestRule(DetailFootballActivity::class.java)

//    @Test
//    fun testRecyclerViewBehaviour() {
//        onView(withId(rv_football_previous_match)).check(matches(isDisplayed()))
//    }

    @Test
    fun testAppBehaviour() {

    }
}