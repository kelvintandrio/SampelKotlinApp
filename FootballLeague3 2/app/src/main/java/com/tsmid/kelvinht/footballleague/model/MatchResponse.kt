package com.tsmid.kelvinht.footballleague.model

import com.google.gson.annotations.SerializedName

data class MatchResponse (
    @field:SerializedName("leagues")
    val events: ArrayList<DetailFootball>? = null
)