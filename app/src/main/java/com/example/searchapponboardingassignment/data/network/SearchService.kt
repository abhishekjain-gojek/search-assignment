package com.example.searchapponboardingassignment.data.network

import com.example.searchapponboardingassignment.data.network.model.ApiResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SearchService {

    @POST("/")
    suspend fun getProduct(@Body query: String): Response<ApiResponse>
}