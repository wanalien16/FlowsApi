package com.example.flow.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NotesDao {
@Insert(onConflict = OnConflictStrategy.IGNORE)
fun insertNote(note: NotesTodo)

@Query("SELECT * FROM NotesTodo")
fun getNotes(): List<NotesTodo>
}