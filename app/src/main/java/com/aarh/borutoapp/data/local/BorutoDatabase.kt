package com.aarh.borutoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aarh.borutoapp.data.local.dao.HeroDao
import com.aarh.borutoapp.data.local.dao.HeroRemoteKeyDao
import com.aarh.borutoapp.domain.model.Hero
import com.aarh.borutoapp.domain.model.HeroRemoteKey

@Database(entities = [Hero::class, HeroRemoteKey::class], version = 1)
abstract class BorutoDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao

    abstract fun heroRemoteKeyDao(): HeroRemoteKeyDao
}
