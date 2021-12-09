package com.jlo.domain.usescases

import com.jlo.domain.common.AsyncResult
import com.jlo.domain.repositories.SearchHistoryRepository
import com.jlo.domain.util.DispatcherProvider
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetSearchHistoryByQueryUseCase @Inject constructor(
    private val searchHistoryRepository: SearchHistoryRepository,
    private val dispatchers: DispatcherProvider
) {
    suspend operator fun invoke(query: String): AsyncResult<List<String>> =
        withContext(dispatchers.io()) {
            searchHistoryRepository.searchHistoryByQuery(query)
        }
}
