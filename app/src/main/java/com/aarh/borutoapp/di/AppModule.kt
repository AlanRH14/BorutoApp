package com.aarh.borutoapp.di

import com.aarh.borutoapp.presentation.screens.detail.DetailsViewModel
import com.aarh.borutoapp.presentation.screens.home.HomeViewModel
import com.aarh.borutoapp.presentation.screens.search.SearchViewModel
import com.aarh.borutoapp.presentation.screens.welcome.WelcomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { WelcomeViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { SearchViewModel(get()) }
    viewModel { DetailsViewModel(get()) }
}