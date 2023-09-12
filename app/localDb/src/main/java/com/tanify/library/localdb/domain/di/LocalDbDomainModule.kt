package com.tanify.library.localdb.domain.di

import android.content.Context
import com.tanify.library.localdb.data.repository.LocalDbRepository
import com.tanify.library.localdb.domain.datasource.LocalDbDataSource
import com.tanify.library.localdb.domain.usecase.crud_db.insert.InsertAppToDbUseCase
import com.tanify.library.localdb.domain.usecase.crud_db.insert.InsertAppToDbUseCaseImpl
import com.tanify.library.localdb.domain.usecase.get_app_device.GetInstallAppPackageUseCase
import com.tanify.library.localdb.domain.usecase.get_app_device.GetInstallAppPackageUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
abstract class LocalDbDomainModule {

    @Binds
    @ViewModelScoped
    abstract fun provideGetInstallAppPackageUseCase(impl: GetInstallAppPackageUseCaseImpl): GetInstallAppPackageUseCase

    @Binds
    @ViewModelScoped
    abstract fun provideInsertAppToDbUseCase(impl: InsertAppToDbUseCaseImpl): InsertAppToDbUseCase
}