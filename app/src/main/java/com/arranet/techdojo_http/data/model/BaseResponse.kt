package com.arranet.techdojo_http.data.model

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("articles") val list: List<T>
)