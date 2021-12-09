package com.jlo.domain.models

data class Product(
    val id: String,
    val title: String,
    val price: Double,
    val availableQuantity: Int,
    val condition: String,
    val image: String
)
