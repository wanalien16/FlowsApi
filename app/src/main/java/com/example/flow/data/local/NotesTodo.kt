package com.example.flow.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class NotesTodo(@PrimaryKey(autoGenerate = true) val id : Int,
    val task: String, val description: String)
