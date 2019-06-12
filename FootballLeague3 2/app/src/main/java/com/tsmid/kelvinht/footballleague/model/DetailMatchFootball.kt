package com.tsmid.kelvinht.footballleague.model

import com.google.gson.annotations.SerializedName
import com.tsmid.kelvinht.footballleague.model.attribute.AttributeDetailMatchFootball

class DetailMatchFootball (
    @field:SerializedName("events")
    val events: ArrayList<AttributeDetailMatchFootball>? = null
)