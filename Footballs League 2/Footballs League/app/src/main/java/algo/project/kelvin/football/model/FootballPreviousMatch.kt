package algo.project.kelvin.football.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FootballPreviousMatch (
    val idEventPM : String,
    val namePM : String,
    val nameFilePM : String,
    val team1PM : String,
    val team2PM : String,
    val dateEventPM : String,
    val timeEventPM : String
) : Parcelable