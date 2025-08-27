package com.aarh.borutoapp.di

import com.aarh.borutoapp.data.repository.DataStoreHandleImpl
import com.aarh.borutoapp.domain.use_case.UseCases
import com.aarh.borutoapp.domain.use_case.get_all_heroes.GetAllHeroesUseCase
import com.aarh.borutoapp.domain.use_case.get_selected_hero.GetSelectedHeroUseCase
import com.aarh.borutoapp.domain.use_case.read_onboarding.ReadOnBoardingUseCase
import com.aarh.borutoapp.domain.use_case.save_onboarding.SaveOnBoardingUseCase
import com.aarh.borutoapp.domain.use_case.search_heroes.SearchHeroesUseCase
import org.koin.dsl.module

val repositoryModule = module {

    single { DataStoreHandleImpl(dataStore = get()) }

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
