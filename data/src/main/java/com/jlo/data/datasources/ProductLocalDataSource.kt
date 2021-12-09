package com.jlo.data.datasources

import com.jlo.domain.models.Product
import com.jlo.domain.models.ProductDetail
import kotlinx.coroutines.flow.Flow

interface ProductLocalDataSource {

    fun listProducts(): Flow<List<Product>>
    suspend fun addProduct(productDetail: ProductDetail)
    suspend fun deleteProduct(productId: String)
}
