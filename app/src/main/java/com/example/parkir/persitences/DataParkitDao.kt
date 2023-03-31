package com.example.parkir.persitences

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.parkir.model.DataParkir

@Dao
interface DataParkitDao {
    @Query("SELECT * FROM DataParkir")
    fun loadAll(): LiveData<List<DataParkir>>
    @Query("SELECT * FROM DataParkir WHERE id = :id")
    fun find(id: String): DataParkir?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: DataParkir)
    @Delete
    fun delete(item: DataParkir)
}