package com.aarh.borutoapp.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingSource.LoadResult
import com.aarh.borutoapp.data.mockdata.HeroProvider.hero1
import com.aarh.borutoapp.data.mockdata.HeroProvider.hero2
import com.aarh.borutoapp.data.mockdata.HeroProvider.hero3
import com.aarh.borutoapp.data.remote.BorutoApi
import com.aarh.borutoapp.data.remote.FakeBorutoApi
import com.aarh.borutoapp.domain.entity.Hero
import junit.framework.Assert.assertEquals

import kotlinx.coroutines.runBlocking
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
            val heroSource = SearchHeroesSource(borutoApi = borutoApi, query = "")
            assertEquals<LoadResult<Int, Hero>>(
                expected = LoadResult.Page(
                    data = listOf(heroes.first()),
                    prevKey = null,
                    nextKey = null,
                ),
                actual = heroSource.load(
                    PagingSource.LoadParams.Refresh(
                        key = null,
                        loadSize = 3,
                        placeholdersEnabled = false
                    )
                )
            )
        }
}