package com.apollo.starwarsinfo.domain.usecase

import com.apollo.starwarsinfo.domain.model.Film
import com.apollo.starwarsinfo.domain.util.FlowUseCase
import kotlinx.coroutines.flow.Flow

class GetFilmsFromLocalUseCase : FlowUseCase<List<Film>>() {
    override fun execute(): Flow<Result<List<Film>>> {
        TODO("Not yet implemented")
    }
}