package com.tanify.library.localdb.domain.di

import com.tanify.library.localdb.domain.usecase.crud_db.delete.DeleteAppFromDbUseCase
import com.tanify.library.localdb.domain.usecase.crud_db.delete.DeleteAppFromDbUseCaseImpl
import com.tanify.library.localdb.domain.usecase.crud_db.get_all.GetAppsFromDbUseCase
import com.tanify.library.localdb.domain.usecase.crud_db.get_all.GetAppsFromDbUseCaseImpl
import com.tanify.library.localdb.domain.usecase.crud_db.insert.InsertAppToDbUseCase
import com.tanify.library.localdb.domain.usecase.crud_db.insert.InsertAppToDbUseCaseImpl
import com.tanify.library.localdb.domain.usecase.get_app_device.GetInstallAppPackageUseCase
import com.tanify.library.localdb.domain.usecase.get_app_device.GetInstallAppPackageUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class LocalDbDomainModule {

    @Binds
    @ViewModelScoped
    abstract fun provideGetInstallAppPackageUseCase(impl: GetInstallAppPackageUseCaseImpl): GetInstallAppPackageUseCase

    @Binds
    @ViewModelScoped
    abstract fun provideInsertAppToDbUseCase(impl: InsertAppToDbUseCaseImpl): InsertAppToDbUseCase

    @Binds
    @ViewModelScoped
    abstract fun provideDeleteAppToDbUseCase(impl: DeleteAppFromDbUseCaseImpl): DeleteAppFromDbUseCase

    @Binds
    @ViewModelScoped
    abstract fun provideGetEnabledAppsToDbUseCase(impl: GetAppsFromDbUseCaseImpl): GetAppsFromDbUseCase
}