package com.jlo.remote_data_source.dto

data class ProductDto(
    val id: String,
    val title: String,
    val price: Double,
    val available_quantity: Int,
    val sold_quantity: Int,
    val condition: String,
    val thumbnail: String,
)
