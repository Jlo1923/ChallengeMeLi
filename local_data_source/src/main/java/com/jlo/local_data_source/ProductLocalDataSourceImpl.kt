package com.jlo.local_data_source

import com.jlo.data.datasources.ProductLocalDataSource
import com.jlo.domain.models.Product
import com.jlo.domain.models.ProductDetail
import com.jlo.local_data_source.dao.ProductDao
import com.jlo.local_data_source.mappers.ProductDetailMapper
import com.jlo.local_data_source.mappers.ProductEntityMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.*
import javax.inject.Inject

class ProductLocalDataSourceImpl @Inject constructor(
    private val dao: ProductDao,
    private val productEntityMapper: ProductEntityMapper,
    private val productDetailMapper: ProductDetailMapper
) : ProductLocalDataSource {

    override fun listProducts(): Flow<List<Product>> = dao.listProductDescending()
        .map(productEntityMapper::toListModel)

    override suspend fun addProduct(productDetail: ProductDetail) {
        val product = productDetailMapper.fromModel(productDetail)
        dao.insert(product)
    }

    override suspend fun deleteProduct(productId: String) {
        dao.deleteByProductId(productId)
    }
}
