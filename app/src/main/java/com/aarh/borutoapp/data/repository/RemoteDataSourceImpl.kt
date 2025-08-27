package com.aarh.borutoapp.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.aarh.borutoapp.data.local.dao.HeroDao
import com.aarh.borutoapp.data.local.dao.HeroRemoteKeysDao
import com.aarh.borutoapp.data.paging_source.HeroRemoteMediator
import com.aarh.borutoapp.data.paging_source.SearchHeroesSource
import com.aarh.borutoapp.data.remote.BorutoApi
import com.aarh.borutoapp.domain.entity.Hero
import com.aarh.borutoapp.domain.repository.RemoteDataSource
import com.aarh.borutoapp.util.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow

@ExperimentalPagingApi
class RemoteDataSourceImpl(
    private val borutoApi: BorutoApi,
    private val heroDao: HeroDao,
    private val heroRemoteKeysDao: HeroRemoteKeysDao,
) : RemoteDataSource {

    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        val pagingSourceFactory = { heroDao.getAllHeroes() }
        return Pager(
            config = PagingConfig(
                pageSize = ITEMS_PER_PAGE,
            ),
            remoteMediator = HeroRemoteMediator(
                api = borutoApi,
                heroDao = heroDao,
                heroRemoteKeysDao = heroRemoteKeysDao,
            ),
            pagingSourceFactory = pagingSourceFactory,
        ).flow
    }

    override fun searchHeroes(query: String): Flow<PagingData<Hero>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                SearchHeroesSource(
                    borutoApi = borutoApi,
                    query = query
                )
            }
        ).flow
    }
}
