package com.example.flow.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [NotesTodo::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
abstract fun notesDao(): NotesDao
}