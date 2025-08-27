package com.aarh.borutoapp.di

import android.content.Context
import com.aarh.borutoapp.data.repository.DataStoreOperationsImpl
import com.aarh.borutoapp.data.repository.Repository
import com.aarh.borutoapp.domain.repository.DataStoreOperations
import com.aarh.borutoapp.domain.use_case.UseCases
import com.aarh.borutoapp.domain.use_case.get_all_heroes.GetAllHeroesUseCase
import com.aarh.borutoapp.domain.use_case.get_selected_hero.GetSelectedHeroUseCase
import com.aarh.borutoapp.domain.use_case.read_onboarding.ReadOnBoardingUseCase
import com.aarh.borutoapp.domain.use_case.save_onboarding.SaveOnBoardingUseCase
import com.aarh.borutoapp.domain.use_case.search_heroes.SearchHeroesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.koin.dsl.module
import javax.inject.Singleton

val repositoryModule = module {

    single {
        UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository = get()),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository = get()),
            getAllHeroesUseCase = GetAllHeroesUseCase(repository = get()),
            searchHeroesUseCase = SearchHeroesUseCase(repository = get()),
            getSelectedHeroUseCase = GetSelectedHeroUseCase(repository = get())
        )
    }
}
