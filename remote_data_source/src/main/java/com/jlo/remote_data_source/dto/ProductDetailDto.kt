package com.jlo.remote_data_source.dto

import java.util.*

data class ProductDetailDto(
    val id: String,
    val title: String,
    val price: Double,
    val available_quantity: Int,
    val sold_quantity: Int,
    val condition: String,
    val pictures: List<ProductPictureDto>,
    val secure_thumbnail: String,
    val attributes: List<ProductAttributesDto>,
    val warranty: String
) {

    data class ProductPictureDto(
        val secure_url: String,
        val size: String,
        val max_size: String,
        val url: String
    )

    data class ProductAttributesDto(
        val id: String,
        val name: String,
        val value_id: String,
        val value_name: String,
    )
}
