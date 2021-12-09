package com.jlo.local_data_source.mappers

import com.jlo.domain.models.ProductDetail
import com.jlo.local_data_source.entities.ProductEntity
import java.util.Date
import javax.inject.Inject

class ProductDetailMapper @Inject constructor() {

    fun fromModel(model: ProductDetail): ProductEntity = ProductEntity(
        date = Date().time,
        productId = model.id,
        title = model.title,
        price = model.price,
        availableQuantity = model.availableQuantity,
        condition = model.condition,
        image = model.thumbnail
    )
}
