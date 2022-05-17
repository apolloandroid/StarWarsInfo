package com.apollo.starwarsinfo.data.character

import com.apollo.starwarsinfo.data.character.local.CharacterDao
import com.apollo.starwarsinfo.data.character.local.CharacterEntity
import com.apollo.starwarsinfo.data.character.remote.CharacterApi
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepository @Inject constructor(
    private val localDataSource: CharacterDao,
    private val remoteDataSource: CharacterApi
) {

    val characters = localDataSource.getAllFlow().map { entities ->
        entities.map { it.mapToDomain() }
    }


    private suspend fun getCharacterFromRemote(characterId: String) {
        val character = remoteDataSource.getCharacterById(characterId).mapToDomain()
        localDataSource.insert(CharacterEntity.mapFromDomain(character))
    }
}