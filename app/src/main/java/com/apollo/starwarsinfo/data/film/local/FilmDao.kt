package com.apollo.starwarsinfo.data.film.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.apollo.starwarsinfo.data.planet.local.PlanetDao
import kotlinx.coroutines.flow.Flow

@Dao
interface FilmDao {

    companion object {
        const val TABLE_NAME = "films"
    }


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(films: List<FilmEntity>)

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAll(): List<FilmEntity>

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllFlow(): Flow<List<FilmEntity>>
}