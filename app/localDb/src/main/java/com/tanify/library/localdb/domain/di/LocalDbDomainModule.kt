package com.tanify.library.localdb.domain.di

import com.tanify.library.localdb.domain.usecase.GetInstallAppPackageUseCase
import com.tanify.library.localdb.domain.usecase.GetInstallAppPackageUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDbDomainModule {

    @Binds
    @Singleton
    abstract fun provideGetInstallAppPackageUseCase(impl: GetInstallAppPackageUseCaseImpl)
            : GetInstallAppPackageUseCase
}