package com.jlo.local_data_source.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "searches",
    indices = [
        Index(value = ["search"], unique = true)
    ]
)
data class SearchEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val search: String = "",
    val date: Long = 0
)
