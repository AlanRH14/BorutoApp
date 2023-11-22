package com.aarh.borutoapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aarh.borutoapp.domain.model.HeroRemoteKey

@Dao
interface HeroRemoteKeyDao {

    @Query("SELECT * FROM hero_remote_key_table WHERE id = :id")
    suspend fun getRemoteKey(id: Int): HeroRemoteKeyDao?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKey(heroesRemoteKeys: List<HeroRemoteKey>)

    @Query("DELETE FROM hero_remote_key_table")
    suspend fun deleteAllRemoteKeys()
}
