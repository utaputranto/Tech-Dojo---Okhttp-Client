package com.arranet.techdojo_http.data.repository

import com.arranet.techdojo_http.data.model.Articles
import com.arranet.techdojo_http.data.model.BaseResponse
import com.arranet.techdojo_http.data.network.ApiService
import com.arranet.techdojo_http.data.network.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : AppRepository {

    override suspend fun getTopHeadlines(country: String): Result<BaseResponse<Articles>> =
        withContext(Dispatchers.IO) {
            val request = apiService.getTopHeadlines(country)
            Result.Success(request)
        }
}