package com.apollo.starwarsinfo.domain.usecase

import com.apollo.starwarsinfo.domain.model.Planet
import com.apollo.starwarsinfo.domain.util.FlowUseCase
import kotlinx.coroutines.flow.Flow

class GetPlanetsFromLocalUseCase : FlowUseCase<List<Planet>>() {
    override fun execute(): Flow<Result<List<Planet>>> {
        TODO("Not yet implemented")
    }
}