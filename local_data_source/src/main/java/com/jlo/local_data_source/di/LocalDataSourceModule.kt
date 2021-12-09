package com.jlo.local_data_source.di

import com.jlo.data.datasources.ProductLocalDataSource
import com.jlo.data.datasources.SearchLocalDataSource
import com.jlo.local_data_source.ProductLocalDataSourceImpl
import com.jlo.local_data_source.SearchLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {

    @Binds
    @Singleton
    abstract fun bindProductLocalDataSource(productLocalDataSourceImpl: ProductLocalDataSourceImpl): ProductLocalDataSource

    @Binds
    @Singleton
    abstract fun bindSearchLocalDataSource(searchLocalDataSourceImpl: SearchLocalDataSourceImpl): SearchLocalDataSource
}
