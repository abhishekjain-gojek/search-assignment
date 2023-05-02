package com.example.searchapponboardingassignment.data

import com.example.searchapponboardingassignment.data.network.model.Product
import com.example.searchapponboardingassignment.data.network.SearchService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.json.JSONObject
import javax.inject.Inject


interface SearchRepository {
    fun searchProduct(query: String): Flow<List<Product>>
}

class SearchRepositoryImpl @Inject constructor(private val searchService: SearchService) :
    SearchRepository {

    override fun searchProduct(query: String): Flow<List<Product>> {
        return flow {
            try {
                val response = searchService.getProduct(query = query)
                emit(response.body()!!.data.searchProduct.products)
            } catch (e: Exception) {
                emit(emptyList())
            }

        }.flowOn(Dispatchers.IO)
    }

}