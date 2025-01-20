package com.aarh.borutoapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aarh.borutoapp.data.local.dao.HeroDao
import com.aarh.borutoapp.data.local.dao.HeroRemoteKeysDao
import com.aarh.borutoapp.domain.entity.Hero
import com.aarh.borutoapp.domain.entity.HeroRemoteKeys
import com.aarh.borutoapp.util.Constants.BORUTO_DATABASE_TEST

@Database(entities = [Hero::class, HeroRemoteKeys::class], version = 1)
@TypeConverters(DataBaseConverter::class)
abstract class BorutoDatabase : RoomDatabase() {

    companion object {
        fun crate(mContext: Context, useInMemory: Boolean): BorutoDatabase {
            val databaseBuilder = if (useInMemory) {
                Room.inMemoryDatabaseBuilder(context = mContext, klass = BorutoDatabase::class.java)
            } else {
                Room.databaseBuilder(
                    context = mContext,
                    klass = BorutoDatabase::class.java,
                    name = BORUTO_DATABASE_TEST
                )
            }

            return databaseBuilder
                .fallbackToDestructiveMigration()
                .build()
        }
    }

    abstract fun heroDao(): HeroDao

    abstract fun heroRemoteKeysDao(): HeroRemoteKeysDao
}
