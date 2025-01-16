package com.aarh.borutoapp.data.remote

import com.aarh.borutoapp.data.mockdata.HeroProvider.hero1
import com.aarh.borutoapp.data.mockdata.HeroProvider.hero2
import com.aarh.borutoapp.data.mockdata.HeroProvider.hero3
import com.aarh.borutoapp.domain.entity.Hero
import com.aarh.borutoapp.domain.model.ApiResponse

class FakeBorutoApi : BorutoApi {

    private val heroes = listOf(
        hero1,
        hero2,
        hero3
    )

    override suspend fun getAllHeroes(page: Int): ApiResponse {
        return ApiResponse(
            success = false
        )
    }

    override suspend fun searchHeroes(name: String): ApiResponse {
        val searchHero = findHeroes(name = name)
        return ApiResponse(
            success = true,
            message = "Ok",
            heroes = searchHero,
        )
    }

    private fun findHeroes(name: String): List<Hero> {
        val founded = mutableListOf<Hero>()
        return if (name.isNotEmpty()) {
            heroes.forEach { hero ->
                if (hero.name.lowercase().contains(name.lowercase())) {
                    founded.add(hero)
                }
            }
            founded
        } else {
            emptyList()
        }
    }
}