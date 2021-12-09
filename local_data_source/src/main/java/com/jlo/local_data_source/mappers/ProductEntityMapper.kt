package com.jlo.local_data_source.mappers

import com.jlo.domain.common.ModelMapper
import com.jlo.domain.models.Product
import com.jlo.local_data_source.entities.ProductEntity
import javax.inject.Inject

class ProductEntityMapper @Inject constructor() : ModelMapper<Product, ProductEntity>() {
    override fun toModel(data: ProductEntity): Product = Product(
        id = data.productId,
        title = data.title,
        price = data.price,
        availableQuantity = data.availableQuantity,
        condition = data.condition,
        image = data.image
    )
}
