package com.example.searchapponboardingassignment.data.network.model

import com.google.gson.annotations.SerializedName


data class ApiResponse(@SerializedName("data") val data: Data)

data class Data(@SerializedName("searchProduct") val searchProduct: SearchProduct)
data class SearchProduct(@SerializedName("products") val products: List<Product>)

data class Product(
    @SerializedName("name") val productName: String? = "",
    @SerializedName("id") val id: Long? = 0
)