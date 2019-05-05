package algo.project.kelvin.football.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FootballNextMatch (
    val idEventNM : String,
    val team1NM : String,
    val team2NM : String,
    val dateEventNM : String,
    val timeEventNM : String
) : Parcelable