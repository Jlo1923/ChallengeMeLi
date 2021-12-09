package com.jlo.domain.usescases

import com.jlo.domain.common.AsyncResult
import com.jlo.domain.models.ProductDetail
import com.jlo.domain.repositories.ProductRepository
import com.jlo.domain.util.DispatcherProvider
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetProductDetailByIdUseCase @Inject constructor(
    private val productRepository: ProductRepository,
    private val dispatchers: DispatcherProvider
) {
    suspend operator fun invoke(id: String): AsyncResult<ProductDetail> =
        withContext(dispatchers.io()) {
            productRepository.productDetailById(id)
        }
}
