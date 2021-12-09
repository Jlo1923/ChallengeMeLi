package com.jlo.domain.repositories

import com.jlo.domain.common.AsyncResult
import com.jlo.domain.models.Product
import com.jlo.domain.models.ProductDetail
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    suspend fun productsByQuery(query: String): AsyncResult<List<Product>>

    suspend fun productDetailById(id: String): AsyncResult<ProductDetail>

    fun recentProducts(): Flow<AsyncResult<List<Product>>>

    suspend fun deleteProductFromRecent(product: Product): AsyncResult<Unit>
}
