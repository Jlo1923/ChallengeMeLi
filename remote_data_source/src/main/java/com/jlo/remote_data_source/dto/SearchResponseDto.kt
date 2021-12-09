package com.jlo.remote_data_source.dto

import java.util.*

data class SearchResponseDto(
    val paging: Paging,
    val results: List<ProductDto>
) {
    data class Paging(
        val total: Int,
        val primary_results: Int,
        val offset: Int,
        val limit: Int
    )
}
