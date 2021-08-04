package com.arranet.techdojo_http.data.model

import com.google.gson.annotations.SerializedName

data class Articles(
    @SerializedName("title") val title: String? = null,
    @SerializedName("description") val description: String? = null
)