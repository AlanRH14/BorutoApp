package com.aarh.borutoapp.di

import android.content.Context
import androidx.room.Room
import com.aarh.borutoapp.data.local.BorutoDatabase
import com.aarh.borutoapp.data.repository.LocalDataSourceImpl
import com.aarh.borutoapp.domain.repository.LocalDataSource
import com.aarh.borutoapp.util.Constants.BORUTO_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providerDatabase(
        @ApplicationContext context: Context,
    ): BorutoDatabase {
        return Room.databaseBuilder(
            context,
            BorutoDatabase::class.java,
            BORUTO_DATABASE,
        ).build()
    }

    @Provides
    @Singleton
    fun providesLocalDataSource(
        database: BorutoDatabase
    ): LocalDataSource {
        return LocalDataSourceImpl(
            borutoDatabase = database
        )
    }
}
