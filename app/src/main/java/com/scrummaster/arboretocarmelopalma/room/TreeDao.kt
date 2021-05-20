package com.scrummaster.arboretocarmelopalma.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TreeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(treeEntity: TreeCacheEntity): Long

    @Query("select * from arboles")
    suspend fun get(): List<TreeCacheEntity>
}