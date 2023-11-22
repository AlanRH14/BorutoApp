package com.aarh.borutoapp.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aarh.borutoapp.domain.model.HeroEntity

@Dao
interface HeroDao {
    @Query("SELECT * FROM hero_table ORDER BY id ASC")
    fun getAllHeroes(): PagingSource<Int, HeroEntity>

    @Query("SELECT * FROM hero_table WHERE id=:heroId")
    fun getSelectedHero(heroId: Int): HeroEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addHeroes(heroEntityEntities: List<HeroEntity>)

    @Query("DELETE FROM hero_table")
    suspend fun deleteAllHeroes()
}
