package com.tsmid.kelvinht.fotballleague2.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FootballDetail internal constructor(
    val nameEvent : String, // strEvent
    val dateEvent : String, // dateEvent
    val timeEvent : String, // strTime
    val nameFileEvent : String, // strFilename
    val logoEvent : String, // strThumb
    val roundEvent : String, // intRound

    val nameTeam1 : String, // strHomeTeam
    val nameTeam2 : String, // strAwayTeam
    val scoreTeam1 : String, // intHomeScore
    val scoreTeam2 : String, // intAwayScore
    val shotTeam1 : String, // intHomeShots
    val shotTeam2 : String, // intAwayShots
    val formationTeam1 : String, // strHomeFormation
    val formationTeam2 : String, // strAwayFormation
    val goalDetailTeam1 : String, // strHomeGoalDetails
    val goalDetailTeam2 : String, // strAwayGoalDetails
    val yellowCardTeam1 : String, // strHomeYellowCards
    val yellowCardTeam2 : String, // strAwayYellowCards
    val redCardTeam1 : String, // strHomeRedCards
    val redCardTeam2 : String // strAwayRedCards
) : Parcelable