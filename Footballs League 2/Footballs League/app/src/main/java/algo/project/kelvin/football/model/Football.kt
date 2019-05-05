package algo.project.kelvin.football.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Football (
    val idFootball: String,
    val titleFootball: String,
    val logoFootball: Int
) : Parcelable