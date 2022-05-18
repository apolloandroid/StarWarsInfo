package com.apollo.starwarsinfo.data.character.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.apollo.starwarsinfo.data.planet.local.PlanetDao
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    companion object {
        const val TABLE_NAME = "characters"
    }


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(character: CharacterEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(characters: List<CharacterEntity>)

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllFlow(): Flow<List<CharacterEntity>>
}