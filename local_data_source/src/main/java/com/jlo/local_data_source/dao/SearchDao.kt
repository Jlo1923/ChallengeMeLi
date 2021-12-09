package com.jlo.local_data_source.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jlo.local_data_source.entities.SearchEntity
import java.util.*

@Dao
interface SearchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(search: SearchEntity)

    @Query("SELECT * FROM searches WHERE search LIKE :query ORDER BY date DESC")
    suspend fun listByQuery(query: String): List<SearchEntity>

    @Query("SELECT * FROM searches ORDER BY date DESC")
    suspend fun listAll(): List<SearchEntity>
}
