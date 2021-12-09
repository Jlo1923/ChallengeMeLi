package com.jlo.remote_data_source.apis

import com.jlo.remote_data_source.dto.ProductDescriptionDto
import com.jlo.remote_data_source.dto.ProductDetailDto
import com.jlo.remote_data_source.dto.SearchResponseDto
import com.jlo.remote_data_source.util.Urls
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

interface ProductApi {

    @GET(Urls.SEARCH)
    suspend fun searchProducts(
        @Path("site") site: String = Urls.SITE,
        @Query("q") query: String
    ): SearchResponseDto

    @GET(Urls.PRODUCT_DETAIL)
    suspend fun productDetail(@Path("id") productId: String): ProductDetailDto

    @GET(Urls.PRODUCT_DESCRIPTION)
    suspend fun productDescription(@Path("id") productId: String): List<ProductDescriptionDto>
}
