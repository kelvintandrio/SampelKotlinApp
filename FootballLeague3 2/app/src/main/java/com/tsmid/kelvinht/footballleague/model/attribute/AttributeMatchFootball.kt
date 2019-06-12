package com.tsmid.kelvinht.footballleague.model.attribute

import com.google.gson.annotations.SerializedName

data class AttributeMatchFootball (
    @field:SerializedName("idEvent")
    val idEvent : String? = null,

    @field:SerializedName("strEvent")
    val nameEvent : String? = null,

    @field:SerializedName("strFileName")
    val nameFileEvent : String? = null,

    @field:SerializedName("strHomeTeam")
    val team1Event : String? = null,

    @field:SerializedName("strAwayTeam")
    val team2Event : String? = null,

    @field:SerializedName("intHomeScore")
    val scoreTeam1Event : String? = null,

    @field:SerializedName("intAwayScore")
    val scoreTeam2Event : String? = null
)