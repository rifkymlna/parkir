package com.example.parkir.persitences

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.parkir.model.DataParkir

@Database(entities = [DataParkir::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun DataParkitDao(): DataParkitDao
}
