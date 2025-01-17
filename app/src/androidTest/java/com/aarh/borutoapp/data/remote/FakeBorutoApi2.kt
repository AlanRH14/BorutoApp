package com.aarh.borutoapp.data.remote

import com.aarh.borutoapp.data.mockdata.PageFakeProvider.page1
import com.aarh.borutoapp.data.mockdata.PageFakeProvider.page2
import com.aarh.borutoapp.data.mockdata.PageFakeProvider.page3
import com.aarh.borutoapp.data.mockdata.PageFakeProvider.page4
import com.aarh.borutoapp.data.mockdata.PageFakeProvider.page5
import com.aarh.borutoapp.domain.entity.Hero
import com.aarh.borutoapp.domain.model.ApiResponse

class FakeBorutoApi2 : BorutoApi {
    private val heroes: Map<Int, List<Hero>> by lazy {
        mapOf(
            1 to page1,
            2 to page2,
            3 to page3,
            4 to page4,
            5 to page5,
        )
    }

    override suspend fun getAllHeroes(page: Int): ApiResponse {
        require(page in 1..5)
        return ApiResponse(
            success = true,
            message = "Ok",
            prevPage = calculate(page)["prevPage"],
            nextPage = calculate(page)["nexPage"],
            heroes = heroes[page] ?: emptyList()
        )
    }

    override suspend fun searchHeroes(name: String): ApiResponse {
        return ApiResponse(
            success = false
        )
    }

    private fun calculate(page: Int): Map<String, Int?> {
        var prevPage: Int? = page
        var nextPage: Int? = page
        if (page in 1..4) {
            nextPage = nextPage?.plus(1)
        }
        if (page in 2..5) {
            prevPage = prevPage?.minus(1)
        }
        if (page == 1) {
            prevPage = null
        }
        if (page == 5) {
            nextPage = null
        }

        return mapOf("prevPage" to prevPage, "nextPage" to nextPage)
    }
}