package com.jlo.local_data_source.di

import com.jlo.local_data_source.dao.ProductDao
import com.jlo.local_data_source.dao.SearchDao
import com.jlo.local_data_source.database.DatabaseProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideSearchDao(databaseProvider: DatabaseProvider): SearchDao = databaseProvider
        .database
        .searchDao()

    @Provides
    @Singleton
    fun provideProductDao(databaseProvider: DatabaseProvider): ProductDao = databaseProvider
        .database
        .productDao()
}
