package com.jlo.data.repositories

import com.jlo.data.datasources.SearchLocalDataSource
import com.jlo.domain.common.AsyncResult
import com.jlo.domain.common.Errors
import com.jlo.domain.repositories.SearchHistoryRepository
import java.util.logging.Logger
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchHistoryRepositoryImpl @Inject constructor(
    private val localDataSource: SearchLocalDataSource
) : SearchHistoryRepository {

    private val logger = Logger.getLogger(SearchHistoryRepositoryImpl::class.simpleName)

    override suspend fun searchHistoryByQuery(query: String): AsyncResult<List<String>> = try {
        val result = localDataSource.searchHistoryByQuery(query)
        AsyncResult.success(result)
    } catch (e: Exception) {
        logger.warning(e.message)
        AsyncResult.error(Errors.DatabaseError)
    }
}
