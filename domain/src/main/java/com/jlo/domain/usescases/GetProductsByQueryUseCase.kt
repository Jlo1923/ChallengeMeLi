package com.jlo.domain.usescases

import com.jlo.domain.common.AsyncResult
import com.jlo.domain.models.Product
import com.jlo.domain.repositories.ProductRepository
import com.jlo.domain.util.DispatcherProvider
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetProductsByQueryUseCase @Inject constructor(
    private val productRepository: ProductRepository,
    private val dispatchers: DispatcherProvider
) {
    suspend operator fun invoke(query: String): AsyncResult<List<Product>> =
        withContext(dispatchers.io()) {
            productRepository.productsByQuery(query)
        }
}
