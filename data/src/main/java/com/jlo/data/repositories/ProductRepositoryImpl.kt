package com.jlo.data.repositories

import com.jlo.data.datasources.ProductLocalDataSource
import com.jlo.data.datasources.ProductRemoteDataSource
import com.jlo.data.datasources.SearchLocalDataSource
import com.jlo.domain.common.AsyncResult
import com.jlo.domain.common.Errors
import com.jlo.domain.models.Product
import com.jlo.domain.models.ProductDetail
import com.jlo.domain.repositories.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import java.util.logging.Logger
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepositoryImpl @Inject constructor(
    private val productLocalDataSource: ProductLocalDataSource,
    private val productRemoteDataSource: ProductRemoteDataSource,
    private val searchLocalDataSource: SearchLocalDataSource
) : ProductRepository {

    private val logger = Logger.getLogger(ProductRepositoryImpl::class.simpleName)

    override suspend fun productsByQuery(query: String): AsyncResult<List<Product>> = try {
        val result = productRemoteDataSource.listProductsByQuery(query)
        searchLocalDataSource.addSearchToHistory(query)
        AsyncResult.success(result)
    } catch (e: IOException) {
        logger.warning(e.message)
        AsyncResult.error(Errors.NetworkError)
    } catch (e: Exception) {
        logger.warning(e.message)
        AsyncResult.error(Errors.UnknownError)
    }

    override suspend fun productDetailById(id: String): AsyncResult<ProductDetail> = try {
        val result = productRemoteDataSource.getProductDetail(id)
        productLocalDataSource.addProduct(result)
        AsyncResult.success(result)
    } catch (e: IOException) {
        logger.warning(e.message)
        AsyncResult.error(Errors.NetworkError)
    } catch (e: Exception) {
        logger.warning(e.message)
        AsyncResult.error(Errors.UnknownError)
    }

    override fun recentProducts(): Flow<AsyncResult<List<Product>>> = productLocalDataSource
        .listProducts()
        .map { AsyncResult.success(it) }
        .catch { emit(AsyncResult.error(Errors.DatabaseError)) }

    override suspend fun deleteProductFromRecent(product: Product): AsyncResult<Unit> = try {
        productLocalDataSource.deleteProduct(product.id)
        AsyncResult.success(Unit)
    } catch (e: Exception) {
        logger.warning(e.message)
        AsyncResult.error(Errors.DatabaseError)
    }
}
