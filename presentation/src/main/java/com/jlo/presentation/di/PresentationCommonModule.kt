package com.jlo.presentation.di

import com.jlo.presentation.common.errors.ErrorMessage
import com.jlo.presentation.common.errors.ErrorMessageImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PresentationCommonModule {

    @Binds
    @Singleton
    abstract fun bindErrorMessage(errorMessageImpl: ErrorMessageImpl): ErrorMessage
}
