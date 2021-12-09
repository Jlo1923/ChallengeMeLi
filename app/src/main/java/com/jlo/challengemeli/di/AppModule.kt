package com.jlo.challengemeli.di

import com.jlo.data.di.RepositoriesModule
import com.jlo.domain.di.DomainUtilModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(
    includes = [
        DomainUtilModule::class,
        RepositoriesModule::class
    ]
)
@InstallIn(SingletonComponent::class)
object AppModule
