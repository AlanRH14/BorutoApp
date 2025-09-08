package com.aarh.borutoapp.navigation

import kotlinx.serialization.Serializable

sealed interface Screen

@Serializable
data object Welcome : Screen

@Serializable
data object Home : Screen

@Serializable
data class Details(val heroID: Int) : Screen

@Serializable
data object Search : Screen
