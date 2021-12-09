package com.jlo.remote_data_source

import com.jlo.data.datasources.ProductRemoteDataSource
import com.jlo.domain.models.Product
import com.jlo.domain.models.ProductDetail
import com.jlo.remote_data_source.apis.ProductApi
import com.jlo.remote_data_source.mappers.ProductDetailDtoMapper
import com.jlo.remote_data_source.mappers.ProductDtoMapper
import javax.inject.Inject

class ProductRemoteDataSourceImpl @Inject constructor(
    private val productApi: ProductApi,
    private val productDtoMapper: ProductDtoMapper,
    private val productDetailDtoMapper: ProductDetailDtoMapper
) : ProductRemoteDataSource {

    override suspend fun listProductsByQuery(query: String): List<Product> {
        val result = productApi.searchProducts(query = query)
        return productDtoMapper.toListModel(result.results)
    }

    override suspend fun getProductDetail(id: String): ProductDetail {
        val result = productApi.productDetail(id)
        val product = productDetailDtoMapper.toModel(result)

        val resultDescription = productApi.productDescription(id)
        val description = if (resultDescription.isNotEmpty()) resultDescription.first().pain_text
        else ""

        return product.copy(description = description)
    }
}
