package com.example.searchapponboardingassignment.ui.screen

import androidx.lifecycle.ViewModel
import com.example.searchapponboardingassignment.data.SearchRepository
import com.example.searchapponboardingassignment.data.network.model.Product
import com.example.searchapponboardingassignment.domain.SearchProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val searchProductUseCase: SearchProductUseCase
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    var products: Flow<List<Product>> = MutableStateFlow(emptyList())

    fun callAPI(query: String) {
        _searchQuery.value = query
        products = _searchQuery
            .debounce(300)
            .distinctUntilChanged()
            .flatMapLatest { query ->
                searchProductUseCase.execute(query, 0)
            }
            .flowOn(Dispatchers.IO)
    }


}