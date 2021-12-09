package com.jlo.domain.usescases

import com.jlo.domain.common.AsyncResult
import com.jlo.domain.models.Product
import com.jlo.domain.repositories.ProductRepository
import com.jlo.domain.util.DispatcherProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetRecentProductsUseCase @Inject constructor(
    private val productRepository: ProductRepository,
    private val dispatchers: DispatcherProvider
) {
    operator fun invoke(): Flow<AsyncResult<List<Product>>> = productRepository.recentProducts()
        .flowOn(dispatchers.io())
}
