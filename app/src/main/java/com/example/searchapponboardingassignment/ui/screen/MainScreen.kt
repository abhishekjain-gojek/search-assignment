package com.example.searchapponboardingassignment.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.searchapponboardingassignment.ui.component.ProductList
import com.example.searchapponboardingassignment.ui.component.SearchView

@Composable
fun MainScreen(viewModel: MainViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column {
            val searchQuery = viewModel.searchQuery.collectAsState().value
            SearchView(text = searchQuery) {
                viewModel.callAPI(it)
            }
            val products by viewModel.products.collectAsState(initial = emptyList())
            ProductList(products = products)
        }

    }
}