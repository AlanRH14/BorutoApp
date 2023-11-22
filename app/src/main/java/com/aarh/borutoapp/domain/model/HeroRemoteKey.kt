package com.aarh.borutoapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aarh.borutoapp.util.Constants.HERO_REMOTE_KEY_TABLE

@Entity(tableName = HERO_REMOTE_KEY_TABLE)
data class HeroRemoteKey(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?,
)
