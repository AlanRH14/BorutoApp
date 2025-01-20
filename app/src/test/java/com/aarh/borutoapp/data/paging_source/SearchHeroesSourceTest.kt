package com.aarh.borutoapp.data.paging_source

import androidx.paging.PagingSource
import com.aarh.borutoapp.data.HeroFakeProvider.hero1
import com.aarh.borutoapp.data.HeroFakeProvider.hero2
import com.aarh.borutoapp.data.HeroFakeProvider.hero3
import com.aarh.borutoapp.data.remote.BorutoApi
import com.aarh.borutoapp.data.remote.FakeBorutoApi
import com.aarh.borutoapp.domain.entity.Hero
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class SearchHeroesSourceTest {

    private lateinit var borutoApi: BorutoApi
    private lateinit var heroes: List<Hero>

    @Before
    fun setup() {
        borutoApi = FakeBorutoApi()
        heroes = listOf(
            hero1,
            hero2,
            hero3
        )
    }

    @Test
    fun `Search api with existing hero name, expect single hero result, assert LoadResult_Page`() =
        runBlocking {
            val heroSource = SearchHeroesSource(borutoApi = borutoApi, query = "Sasuke")
            assertEquals(
                PagingSource.LoadResult.Page(
                    data = listOf(heroes.first()),
                    prevKey = null,
                    nextKey = null
                ),
                heroSource.load(
                    PagingSource.LoadParams.Refresh(
                        key = null,
                        loadSize = 3,
                        placeholdersEnabled = false
                    )
                )
            )
        }

    @Test
    fun `Search api with existing hero name, expect multiple hero result, assert LoadingResult_Page`() =
        runBlocking {
            val heroSource = SearchHeroesSource(borutoApi = borutoApi, query = "sa")
            assertEquals(
                PagingSource.LoadResult.Page(
                    data = listOf(heroes.first(), hero3),
                    prevKey = null,
                    nextKey = null,
                ),
                heroSource.load(
                    PagingSource.LoadParams.Refresh(
                        key = null,
                        loadSize = 2,
                        placeholdersEnabled = false
                    )
                )
            )
        }

    @Test
    fun `Search api with empty hero name, assert empty heroes list and LoadResult_Page`() =
        runBlocking {
            val heroSource = SearchHeroesSource(borutoApi = borutoApi, query = "")
            val loadResult = heroSource.load(
                PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = 0,
                    placeholdersEnabled = false
                )
            )
            val result = borutoApi.searchHeroes(name = "").heroes

            assertTrue(result.isEmpty())
            assertTrue(loadResult is PagingSource.LoadResult.Page)
        }

    @Test
    fun `Search api with non_existing hero name, assert empty heroes list and LoadResult_Page`() =
        runBlocking {
            val heroSource = SearchHeroesSource(borutoApi = borutoApi, query = "Unknown")
            val loadResult = heroSource.load(
                PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = 0,
                    placeholdersEnabled = false,
                )
            )
            val result = borutoApi.searchHeroes(name = "Unknown").heroes

            assertTrue(result.isEmpty())
            assertTrue(loadResult is PagingSource.LoadResult.Page)
        }
}