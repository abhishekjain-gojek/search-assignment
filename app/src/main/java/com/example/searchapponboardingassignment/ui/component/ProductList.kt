package com.example.searchapponboardingassignment.ui.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.searchapponboardingassignment.data.network.model.Product

@Composable
fun ProductList(products: List<Product>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {

        if (products.isEmpty()) {
            item {
                Text(text = "No Item to display")
            }
        }
        items(
            items = products,
            key = { product -> product.id ?: 0 }) { product ->
            ProductItem(product = product)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProductListPreview() {
    ProductList(emptyList())
}