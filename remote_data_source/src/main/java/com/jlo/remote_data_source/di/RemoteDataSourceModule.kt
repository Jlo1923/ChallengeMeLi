package com.jlo.remote_data_source.di

import com.jlo.remote_data_source.ProductRemoteDataSourceImpl
import com.jlo.data.datasources.ProductRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    @Singleton
    abstract fun bindProductRemoteDataSource(productRemoteDataSourceImpl: ProductRemoteDataSourceImpl): ProductRemoteDataSource
}
