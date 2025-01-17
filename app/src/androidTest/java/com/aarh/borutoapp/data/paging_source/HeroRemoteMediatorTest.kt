package com.aarh.borutoapp.data.paging_source

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingConfig
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.test.core.app.ApplicationProvider
import com.aarh.borutoapp.data.local.BorutoDatabase
import com.aarh.borutoapp.data.remote.FakeBorutoApi2
import com.aarh.borutoapp.domain.entity.Hero
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class HeroRemoteMediatorTest {

    private lateinit var borutoApi: FakeBorutoApi2
    private lateinit var borutoDatabase: BorutoDatabase

    @Before
    fun setUp() {
        borutoApi = FakeBorutoApi2()
        borutoDatabase = BorutoDatabase.crate(
            mContext = ApplicationProvider.getApplicationContext(),
            useInMemory = true
        )
    }

    @After
    fun cleanUp() {
        borutoDatabase.clearAllTables()
    }

    @OptIn(ExperimentalPagingApi::class)
    @Test
    fun refreshLoadResultReturnsSuccessResultWhenMoreDataIsPresent() =
        runBlocking {
            val remoteMediator = HeroRemoteMediator(
                borutoApi = borutoApi,
                borutoDatabase = borutoDatabase
            )
            val pagingState = PagingState<Int, Hero>(
                pages = listOf(),
                anchorPosition = null,
                config = PagingConfig(pageSize = 3),
                leadingPlaceholderCount = 0,
            )
            val result = remoteMediator.load(LoadType.REFRESH, pagingState)
            assertTrue(result is RemoteMediator.MediatorResult.Success)
            assertFalse((result as RemoteMediator.MediatorResult.Success).endOfPaginationReached)
        }
}