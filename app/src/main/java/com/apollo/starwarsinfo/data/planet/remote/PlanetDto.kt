package com.apollo.starwarsinfo.data.planet.remote

import com.apollo.starwarsinfo.domain.model.Planet
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlanetDto(
    @SerialName("url")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("diameter")
    val diameter: String,
    @SerialName("climate")
    val climate: String,
    @SerialName("gravity")
    val gravity: String,
    @SerialName("terrain")
    val terrain: String,
    @SerialName("population")
    val populationCount: String
) {

    fun mapToDomain(): Planet = Planet(
        id = this.id.filter { it.isDigit() },
        name = this.name,
        diameter = this.diameter,
        climate = this.climate,
        gravity = this.gravity,
        terrain = this.terrain,
        populationCount = this.populationCount
    )
}