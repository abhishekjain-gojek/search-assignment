package com.example.searchapponboardingassignment.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.searchapponboardingassignment.data.network.model.Product

@Composable
fun ProductItem(product: Product) {
    Card(modifier = Modifier.padding(10.dp)) {
        Text(text = product.productName.orEmpty())
    }
}


@Preview(showBackground = true)
@Composable
fun ProductItemPreview() {
    ProductItem(Product("Mouse", 1))
}