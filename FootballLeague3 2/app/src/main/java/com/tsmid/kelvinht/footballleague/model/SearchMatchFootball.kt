package com.tsmid.kelvinht.footballleague.model

import com.google.gson.annotations.SerializedName
import com.tsmid.kelvinht.footballleague.model.attribute.AttributeMatchFootball

data class SearchMatchFootball (
    @field:SerializedName("event")
    val events: ArrayList<AttributeMatchFootball>? = null
)