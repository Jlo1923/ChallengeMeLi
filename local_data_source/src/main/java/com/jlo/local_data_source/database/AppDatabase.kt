package com.jlo.local_data_source.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jlo.local_data_source.dao.ProductDao
import com.jlo.local_data_source.dao.SearchDao
import com.jlo.local_data_source.entities.ProductEntity
import com.jlo.local_data_source.entities.SearchEntity

@Database(version = 1, entities = [ProductEntity::class, SearchEntity::class])
abstract class AppDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao
    abstract fun searchDao(): SearchDao
}
