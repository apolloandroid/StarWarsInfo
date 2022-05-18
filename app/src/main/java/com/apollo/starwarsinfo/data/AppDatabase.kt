package com.apollo.starwarsinfo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.apollo.starwarsinfo.data.character.local.CharacterDao
import com.apollo.starwarsinfo.data.character.local.CharacterEntity
import com.apollo.starwarsinfo.data.film.local.FilmDao
import com.apollo.starwarsinfo.data.film.local.FilmEntity
import com.apollo.starwarsinfo.data.planet.local.PlanetDao
import com.apollo.starwarsinfo.data.planet.local.PlanetEntity

@Database(
    entities = [
        CharacterEntity::class,
        FilmEntity::class,
        PlanetEntity::class
    ],
    version = 1
)
@TypeConverters(StringConverter::class)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val NAME = "star_wars_database"
    }


    abstract fun characterDao(): CharacterDao

    abstract fun filmDao(): FilmDao

    abstract fun planetDao(): PlanetDao
}