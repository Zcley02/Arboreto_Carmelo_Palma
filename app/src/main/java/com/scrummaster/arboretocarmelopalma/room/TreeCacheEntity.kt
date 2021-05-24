package com.scrummaster.arboretocarmelopalma.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "arboles")
class TreeCacheEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Int,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "scientific_name")
    var scientific_name: String,
    @ColumnInfo(name = "family")
    var family: String,
    @ColumnInfo(name = "distribution")
    var distribution: String,
    @ColumnInfo(name = "description")
    var description: String,
    @ColumnInfo(name = "utility")
    var utility: String,
    @ColumnInfo(name = "image")
    var image: String

)