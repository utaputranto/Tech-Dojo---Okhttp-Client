package com.arranet.techdojo_http.data.network

import com.arranet.techdojo_http.data.model.Articles
import com.arranet.techdojo_http.data.model.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines/")
    suspend fun getTopHeadlines(@Query("country") country: String? = null
    ): BaseResponse<Articles>
}