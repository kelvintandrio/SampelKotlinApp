package com.tsmid.kelvinht.fotballleague2.view

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.tsmid.kelvinht.fotballleague2.R.id.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DetailFootballTest {

    @Rule
    @JvmField var activityRule = ActivityTestRule(DetailFootball::class.java)

//    @Test
//    fun testRecyclerViewBehaviour() {
//        onView(withId(rv_football_search_match)).check(matches(isDisplayed()))
//        onView(withId(rv_football_search_match)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(1))
//        onView(withId(rv_football_search_match)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, click()))
//    }

    @Test
    fun testAppBehaviour() {

        onView(withId(search_event_football)).perform(typeText("chelsea"), click())
        onView(withId(btnSearchFootball)).perform(click())
    }
}