package com.tanify.library.localdb.data.di

import android.content.Context
import androidx.room.Room
import com.tanify.library.localdb.data.WhiteListAppDao
import com.tanify.library.localdb.data.WhiteListAppDatabase
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
    fun provideWhiteListAppDatabase(@ApplicationContext appContext: Context): WhiteListAppDatabase {
        return Room.databaseBuilder(
            appContext,
            WhiteListAppDatabase::class.java,
            WhiteListAppDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideWhiteListAppDao(
        whiteListAppDatabase: WhiteListAppDatabase
    ): WhiteListAppDao {
        return whiteListAppDatabase.whiteListAppDao()
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class AbsLocalDbDataModule {
    @Binds
    @Singleton
    abstract fun provideLocalDbDataSource(impl: LocalDbRepository): LocalDbDataSource
}