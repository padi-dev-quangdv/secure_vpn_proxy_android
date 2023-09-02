package com.tanify.library.localdb.data.di

import android.content.Context
import com.tanify.library.localdb.data.repository.LocalDbRepository
import com.tanify.library.localdb.domain.datasource.LocalDbDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDbDataModule {

    @Provides
    @Singleton
    fun provideLocalDbDataSource(@ApplicationContext context: Context): LocalDbDataSource {
        return LocalDbRepository(context)
    }
}