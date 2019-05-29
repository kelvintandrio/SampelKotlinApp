package com.tsmid.kelvinht.footballleague.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Football (val idFootball: String, val titleFootball: String, val logoFootball: Int) : Parcelable