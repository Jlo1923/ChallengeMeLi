package com.jlo.remote_data_source.di

import com.jlo.remote_data_source.apis.ApiProvider
import com.jlo.remote_data_source.apis.ProductApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideProductApi(provider: ApiProvider): ProductApi =
        provider.create(ProductApi::class.java)
}
