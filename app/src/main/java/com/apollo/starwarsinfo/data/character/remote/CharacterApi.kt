package com.apollo.starwarsinfo.data.character.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApi {

    @GET("/people/{:id}")
    suspend fun getCharacterById(
        @Path(":id") id: String
    ): CharacterDto
}