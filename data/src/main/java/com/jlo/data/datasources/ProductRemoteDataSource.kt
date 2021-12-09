package com.jlo.data.datasources

import com.jlo.domain.models.Product
import com.jlo.domain.models.ProductDetail

interface ProductRemoteDataSource {

    suspend fun listProductsByQuery(query: String): List<Product>
    suspend fun getProductDetail(id: String): ProductDetail
}
