package com.jlo.local_data_source.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jlo.local_data_source.entities.ProductEntity
import kotlinx.coroutines.flow.Flow
import java.util.*

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(product: ProductEntity)

    @Query("SELECT * FROM products ORDER BY date DESC")
    fun listProductDescending(): Flow<List<ProductEntity>>

    @Query("DELETE FROM products WHERE productId = :productId")
    suspend fun deleteByProductId(productId: String)
}
