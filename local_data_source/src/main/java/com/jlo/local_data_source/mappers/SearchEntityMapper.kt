package com.jlo.local_data_source.mappers

import com.jlo.domain.common.ModelMapper
import com.jlo.local_data_source.entities.SearchEntity
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class SearchEntityMapper @Inject constructor() : ModelMapper<String, SearchEntity>() {

    override fun toModel(data: SearchEntity): String {
        return firstCharToUpperCase(data.search)
    }

    override fun fromModel(model: String): SearchEntity = SearchEntity(
        search = model.toLowerCase(Locale.getDefault()),
        date = Date().time
    )

    private fun firstCharToUpperCase(value: String): String {
        val first = value[0].toUpperCase()
        return "$first${value.substring(1, value.length)}"
    }
}
