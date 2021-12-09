package com.jlo.local_data_source

import com.jlo.data.datasources.SearchLocalDataSource
import com.jlo.local_data_source.dao.SearchDao
import com.jlo.local_data_source.mappers.SearchEntityMapper
import java.util.*
import javax.inject.Inject

class SearchLocalDataSourceImpl @Inject constructor(
    private val dao: SearchDao,
    private val searchEntityMapper: SearchEntityMapper
) : SearchLocalDataSource {
    override suspend fun searchHistoryByQuery(query: String): List<String> {
        val searches = if (query == "") {
            dao.listAll()
        } else {
            val matcher = "${query.toLowerCase(Locale.getDefault())}%"
            dao.listByQuery(matcher)
        }
        return searchEntityMapper.toListModel(searches)
    }

    override suspend fun addSearchToHistory(search: String) {
        val entity = searchEntityMapper.fromModel(search)
        dao.insert(entity)
    }
}
