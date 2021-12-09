package com.jlo.data.di

import com.jlo.data.repositories.ProductRepositoryImpl
import com.jlo.data.repositories.SearchHistoryRepositoryImpl
import com.jlo.domain.repositories.ProductRepository
import com.jlo.domain.repositories.SearchHistoryRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoriesModule {

    @Binds
    @Singleton
    abstract fun bindProductRepository(productRepositoryImpl: ProductRepositoryImpl): ProductRepository

    @Binds
    @Singleton
    abstract fun bindSearchHistoryRepository(searchHistoryRepositoryImpl: SearchHistoryRepositoryImpl): SearchHistoryRepository
}
