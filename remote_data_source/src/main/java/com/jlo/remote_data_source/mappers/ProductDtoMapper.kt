package com.jlo.remote_data_source.mappers

import com.jlo.domain.common.ModelMapper
import com.jlo.domain.models.Product
import com.jlo.remote_data_source.dto.ProductDto
import javax.inject.Inject

class ProductDtoMapper @Inject constructor() : ModelMapper<Product, ProductDto>() {
    override fun toModel(data: ProductDto): Product = Product(
        id = data.id,
        title = data.title,
        price = data.price,
        availableQuantity = data.available_quantity,
        condition = data.condition,
        image = urlToSecure(data.thumbnail)
    )

    private fun urlToSecure(url: String): String {
        return if (url.startsWith("http:")) {
            "https:${url.substring(6, url.length)}"
        } else {
            url
        }
    }
}
