package com.scrummaster.arboretocarmelopalma.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TreeCacheEntity::class], version = 1)
abstract class TreeDatabase : RoomDatabase() {

    companion object{
        val DATABASE_NAME = "treeDB"
    }

    abstract fun treeDao(): TreeDao
}