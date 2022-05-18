package com.apollo.starwarsinfo.data.planet.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface PlanetApi {

    @GET("/planets/{:id}")
    suspend fun getPlanetById(
        @Path(":id") id: String
    ): PlanetDto
}