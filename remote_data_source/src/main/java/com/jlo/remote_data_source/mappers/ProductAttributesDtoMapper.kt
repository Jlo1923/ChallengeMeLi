package com.jlo.remote_data_source.mappers

import com.jlo.domain.common.ModelMapper
import com.jlo.domain.models.ProductAttribute
import com.jlo.remote_data_source.dto.ProductDetailDto
import javax.inject.Inject

class ProductAttributesDtoMapper @Inject constructor() :
    ModelMapper<ProductAttribute, ProductDetailDto.ProductAttributesDto>() {
    override fun toModel(data: ProductDetailDto.ProductAttributesDto): ProductAttribute =
        ProductAttribute(
            id = data.id,
            name = data.name,
            value = data.value_name
        )
}
