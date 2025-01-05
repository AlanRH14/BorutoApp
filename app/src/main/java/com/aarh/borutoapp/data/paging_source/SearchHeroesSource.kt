package com.aarh.borutoapp.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.aarh.borutoapp.data.remote.BorutoApi
import com.aarh.borutoapp.domain.entity.Hero
import javax.inject.Inject

class SearchHeroesSource @Inject constructor(
    private val borutoApi: BorutoApi,
    private val query: String
): PagingSource<Int, Hero>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Hero> {
        TODO("Not yet implemented")
    }

    override fun getRefreshKey(state: PagingState<Int, Hero>): Int? {
        TODO("Not yet implemented")
    }
}