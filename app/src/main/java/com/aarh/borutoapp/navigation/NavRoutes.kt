package com.aarh.borutoapp.navigation

import kotlinx.serialization.Serializable

interface NavRoutes

@Serializable
data object Welcome : NavRoutes

@Serializable
data object Home : NavRoutes

@Serializable
data class Details(val heroID: Int) : NavRoutes

@Serializable
data object Search : NavRoutes
