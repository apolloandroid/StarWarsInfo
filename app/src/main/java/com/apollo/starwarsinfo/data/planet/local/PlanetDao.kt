package com.apollo.starwarsinfo.data.planet.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PlanetDao {

    companion object {
        const val TABLE_NAME = "planets"
    }


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(planet: PlanetEntity)

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAll(): List<PlanetEntity>

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllFlow(): Flow<List<PlanetEntity>>
}