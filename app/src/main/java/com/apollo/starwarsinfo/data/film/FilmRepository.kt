package com.apollo.starwarsinfo.data.film

import com.apollo.starwarsinfo.data.film.local.FilmDao
import com.apollo.starwarsinfo.data.film.local.FilmEntity
import com.apollo.starwarsinfo.data.film.remote.FilmApi
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FilmRepository @Inject constructor(
    private val localDataSource: FilmDao,
    private val remoteDataSource: FilmApi
) {

    val films = localDataSource.getAllFlow().map { entities -> entities.map { it.mapToDomain() } }


    suspend fun getFilmsFromLocal() = localDataSource.getAll()

    suspend fun getFilmsFromRemote() {
        val films = remoteDataSource.getFilms().results.map { it.mapToDomain() }
        localDataSource.insertAll(films.map { FilmEntity.mapFromDomain(it) })
    }
}