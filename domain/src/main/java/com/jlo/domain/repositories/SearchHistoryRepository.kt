package com.jlo.domain.repositories

import com.jlo.domain.common.AsyncResult

interface SearchHistoryRepository {

    suspend fun searchHistoryByQuery(query: String): AsyncResult<List<String>>
}
