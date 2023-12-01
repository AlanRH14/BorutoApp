package com.aarh.borutoapp.di

import android.content.Context
import com.aarh.borutoapp.data.repository.DataStoreOperationsImpl
import com.aarh.borutoapp.data.repository.Repository
import com.aarh.borutoapp.domain.repository.DataStoreOperations
import com.aarh.borutoapp.domain.use_case.UseCases
import com.aarh.borutoapp.domain.use_case.get_all_heroes.GetAllHeroesUseCase
import com.aarh.borutoapp.domain.use_case.read_onboarding.ReadOnBoardingUseCase
import com.aarh.borutoapp.domain.use_case.save_onboarding.SaveOnBoardingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesDataStoreOperations(
        @ApplicationContext context: Context,
    ): DataStoreOperations {
        return DataStoreOperationsImpl(context = context)
    }

    @Provides
    @Singleton
    fun providesUseCases(repository: Repository): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository),
            getAllHeroesUseCase = GetAllHeroesUseCase(repository),
        )
    }
}
