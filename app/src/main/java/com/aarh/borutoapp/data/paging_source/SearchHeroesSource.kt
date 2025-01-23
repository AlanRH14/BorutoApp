package com.aarh.borutoapp.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.aarh.borutoapp.data.remote.BorutoApi
import com.aarh.borutoapp.domain.entity.Hero

class SearchHeroesSource(
    private val borutoApi: BorutoApi,
    private val query: String
) : PagingSource<Int, Hero>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Hero> {
        return try {
            val apiResponse = borutoApi.searchHeroes(name = query)
            val heroes = apiResponse.heroes
            if (heroes.isNotEmpty()) {
                LoadResult.Page(
                    data = heroes,
                    prevKey = apiResponse.prevPage,
                    nextKey = apiResponse.nextPage,
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(throwable = e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Hero>): Int? {
        return state.anchorPosition
    }
}