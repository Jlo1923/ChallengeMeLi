package com.jlo.domain.di

import com.jlo.domain.util.DispatcherProvider
import com.jlo.domain.util.DispatcherProviderImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class DomainUtilModule {
    @Binds
    @Singleton
    abstract fun bindDispatcherProvider(dispatcherProviderImpl: DispatcherProviderImpl): DispatcherProvider
}
