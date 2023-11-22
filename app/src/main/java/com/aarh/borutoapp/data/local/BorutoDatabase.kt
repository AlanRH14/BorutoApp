package com.aarh.borutoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aarh.borutoapp.data.local.dao.HeroDao
import com.aarh.borutoapp.domain.model.HeroEntity

@Database(entities = [HeroEntity::class], version = 1)
abstract class BorutoDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao
}
