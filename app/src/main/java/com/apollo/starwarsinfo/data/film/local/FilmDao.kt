package com.apollo.starwarsinfo.data.film.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FilmDao {

    companion object {
        const val TABLE_NAME = "films"
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(films: List<FilmEntity>)

    @Query("SELECT * FROM films")
    fun getAll(): List<FilmEntity>

    @Query("SELECT * FROM films")
    fun getAllFlow(): Flow<List<FilmEntity>>
}