package com.tsmid.kelvinht.footballleague.model

import com.google.gson.annotations.SerializedName
import com.tsmid.kelvinht.footballleague.model.attribute.AttributeDetailFootball

data class DetailFootball (
    @field:SerializedName("leagues")
    val events: ArrayList<AttributeDetailFootball>? = null
)