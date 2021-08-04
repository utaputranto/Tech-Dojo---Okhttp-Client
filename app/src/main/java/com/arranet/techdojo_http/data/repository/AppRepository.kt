package com.arranet.techdojo_http.data.repository

import com.arranet.techdojo_http.data.model.Articles
import com.arranet.techdojo_http.data.model.BaseResponse
import com.arranet.techdojo_http.data.network.Result

interface AppRepository {
    suspend fun getTopHeadlines(country: String): Result<BaseResponse<Articles>>
}