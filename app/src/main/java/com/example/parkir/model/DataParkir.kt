package com.example.parkir.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataParkir (
    @PrimaryKey val id : String,
    val  platnomer : String,
    val noparkir : String,
    val tanggal : String,
    val petugas : String,
        )
