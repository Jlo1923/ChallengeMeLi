package com.jlo.local_data_source.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "products",
    indices = [
        Index(value = ["productId"], unique = true)
    ]
)
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val date: Long = 0,
    val productId: String = "",
    val title: String = "",
    val price: Double = 0.0,
    val availableQuantity: Int = 0,
    val condition: String = "",
    val image: String = ""
)
