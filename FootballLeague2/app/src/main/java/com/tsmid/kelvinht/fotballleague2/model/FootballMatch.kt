package com.tsmid.kelvinht.fotballleague2.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FootballMatch internal constructor(
    val idEvent : String,
    val name : String,
    val nameFile : String,
    val team1 : String,
    val team2 : String,
    val scoreTeam1 : String,
    val scoreTeam2 : String
) : Parcelable