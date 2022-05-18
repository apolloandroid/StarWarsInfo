package com.apollo.starwarsinfo.di

import android.content.Context
import androidx.room.Room
import com.apollo.starwarsinfo.data.AppDatabase
import com.apollo.starwarsinfo.data.character.local.CharacterDao
import com.apollo.starwarsinfo.data.film.local.FilmDao
import com.apollo.starwarsinfo.data.planet.local.PlanetDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room
            .databaseBuilder(context, AppDatabase::class.java, AppDatabase.NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideCharacterDao(database: AppDatabase): CharacterDao = database.characterDao()

    @Provides
    fun provideFilmDao(database: AppDatabase): FilmDao = database.filmDao()

    @Provides
    fun providePlanetDao(database: AppDatabase): PlanetDao = database.planetDao()
}