package com.example.searchapponboardingassignment.domain

import com.example.searchapponboardingassignment.data.SearchRepository
import com.example.searchapponboardingassignment.data.network.model.Product
import com.example.searchapponboardingassignment.domain.query.getProductSearchGql
import kotlinx.coroutines.flow.Flow
import org.json.JSONObject
import javax.inject.Inject

class SearchProductUseCase @Inject constructor(private val repository: SearchRepository) {
    fun execute(searchQuery: String, start: Int): Flow<List<Product>> {
        val body = JSONObject().apply {
            put("query", getProductSearchGql(searchQuery, start))
        }.toString()

        return repository.searchProduct(body)
    }
}