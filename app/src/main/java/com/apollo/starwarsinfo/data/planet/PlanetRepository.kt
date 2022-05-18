package com.apollo.starwarsinfo.data.planet

import com.apollo.starwarsinfo.data.planet.local.PlanetDao
import com.apollo.starwarsinfo.data.planet.local.PlanetEntity
import com.apollo.starwarsinfo.data.planet.remote.PlanetApi
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlanetRepository @Inject constructor(
    private val localDataSource: PlanetDao,
    private val remoteDataSource: PlanetApi
) {

    val planets = localDataSource.getAllFlow().map { entities -> entities.map { it.mapToDomain() } }


    suspend fun getPlanetsFromLocal() = localDataSource.getAll()

    private suspend fun getPlanetFromRemoteById(id: String) {
        val planet = remoteDataSource.getPlanetById(id).mapToDomain()
        localDataSource.insert(PlanetEntity.mapFromDomain(planet))
    }
}