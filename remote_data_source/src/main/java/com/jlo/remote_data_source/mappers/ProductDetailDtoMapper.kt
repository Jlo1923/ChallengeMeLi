package com.jlo.remote_data_source.mappers

import com.jlo.domain.common.ModelMapper
import com.jlo.domain.models.ProductDetail
import com.jlo.remote_data_source.dto.ProductDetailDto
import javax.inject.Inject

class ProductDetailDtoMapper @Inject constructor(
    private val productAttributesDtoMapper: ProductAttributesDtoMapper
) : ModelMapper<ProductDetail, ProductDetailDto>() {
    override fun toModel(data: ProductDetailDto): ProductDetail = ProductDetail(
        id = data.id,
        title = data.title,
        price = data.price,
        availableQuantity = data.available_quantity,
        soldQuantity = data.sold_quantity,
        condition = data.condition,
        images = data.pictures.map { it.secure_url },
        thumbnail = data.secure_thumbnail,
        description = null,
        warranty = data.warranty,
        attributes = productAttributesDtoMapper.toListModel(data.attributes)
    )
}
