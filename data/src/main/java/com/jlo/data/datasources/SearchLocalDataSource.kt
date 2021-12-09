package com.jlo.data.datasources

interface SearchLocalDataSource {
    suspend fun searchHistoryByQuery(query: String): List<String>
    suspend fun addSearchToHistory(search: String)
}
