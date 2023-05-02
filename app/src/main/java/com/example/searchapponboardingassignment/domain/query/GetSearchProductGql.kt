package com.example.searchapponboardingassignment.domain.query

fun getProductSearchGql(searchQuery: String, start: Int): String {
    return "query SearchProduct() {\n" +
            "searchProduct(params: \"q=$searchQuery&source=search_product&userId=null&device=android&rows=10&start=$start\") {\n" +
            "   products {\n" +
            "     id\n" +
            "     name\n" +
            "    category_breadcrumb\n" +
            "     url\n" +
            "     image_url\n" +
            "     image_url_700\n" +
            "     price\n" +
            "     ga_key\n" +
            "   }\n" +
            "   catalogs {\n" +
            "     id\n" +
            "     name\n" +
            "     price\n" +
            "     price_min\n" +
            "     price_max\n" +
            "     price_raw\n" +
            "     price_min_raw\n" +
            "     price_max_raw\n" +
            "     count_product\n" +
            "     description\n" +
            "     image_url\n" +
            "     url\n" +
            "     department_id\n" +
            "   }\n" +
            " }\n" +
            "\t\n" +
            "}"
}