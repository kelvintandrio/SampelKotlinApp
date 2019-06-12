package com.tsmid.kelvinht.footballleague.model

import com.google.gson.annotations.SerializedName
import com.tsmid.kelvinht.footballleague.model.attribute.AttributeMatchFootball

data class MatchFootball (
    @field:SerializedName("events")
    val events: ArrayList<AttributeMatchFootball>? = null
)