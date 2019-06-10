package com.tsmid.kelvinht.footballleague.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class DetailFootball(

    @field:SerializedName("strLeague")
    val nameFootball : String? = null,

    @field:SerializedName("strLogo")
    val logoFootball : String? = null,

    @field:SerializedName("intFormedYear")
    val yearFootball : String? = null,

    @field:SerializedName("strCountry")
    val countryFootball : String? = null,

    @field:SerializedName("strWebsite")
    val websiteFootball : String? = null
)