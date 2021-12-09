package com.jlo.domain.usescases

import com.jlo.domain.models.Product
import com.jlo.domain.repositories.ProductRepository
import com.jlo.domain.util.DispatcherProvider
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeleteProductFromRecentUseCase @Inject constructor(
    private val productRepository: ProductRepository,
    private val dispatchers: DispatcherProvider
) {
    suspend operator fun invoke(product: Product) = withContext(dispatchers.io()) {
        productRepository.deleteProductFromRecent(product)
    }
}
