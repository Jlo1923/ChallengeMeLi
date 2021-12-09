package com.jlo.domain.models

import com.jlo.domain.models.ProductAttribute

data class ProductDetail(
    val id: String,
    val title: String,
    val price: Double,
    val availableQuantity: Int,
    val soldQuantity: Int,
    val condition: String,
    val images: List<String>,
    val thumbnail: String,
    val description: String?,
    val attributes: List<ProductAttribute>,
    val warranty: String
)
