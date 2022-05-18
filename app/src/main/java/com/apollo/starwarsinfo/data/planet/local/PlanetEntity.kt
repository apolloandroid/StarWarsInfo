package com.apollo.starwarsinfo.data.planet.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.apollo.starwarsinfo.domain.model.Planet

@Entity
data class PlanetEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "diameter")
    val diameter: String,
    @ColumnInfo(name = "climate")
    val climate: String,
    @ColumnInfo(name = "gravity")
    val gravity: String,
    @ColumnInfo(name = "terrain")
    val terrain: String,
    @ColumnInfo(name = "population_count")
    val populationCount: String
) {

    companion object {
        fun mapFromDomain(planet: Planet): PlanetEntity = PlanetEntity(
            id = planet.id,
            name = planet.name,
            diameter = planet.diameter,
            climate = planet.climate,
            gravity = planet.gravity,
            terrain = planet.terrain,
            populationCount = planet.populationCount
        )
    }

    fun mapToDomain(): Planet = Planet(
        id = this.id,
        name = this.name,
        diameter = this.diameter,
        climate = this.climate,
        gravity = this.gravity,
        terrain = this.terrain,
        populationCount = this.populationCount
    )
}