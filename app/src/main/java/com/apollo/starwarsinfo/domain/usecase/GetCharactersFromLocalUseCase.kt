package com.apollo.starwarsinfo.domain.usecase

import com.apollo.starwarsinfo.domain.model.Character
import com.apollo.starwarsinfo.domain.util.FlowUseCase
import kotlinx.coroutines.flow.Flow

class GetCharactersFromLocalUseCase : FlowUseCase<List<Character>>() {

    override fun execute(): Flow<Result<List<Character>>> {
        TODO("Not yet implemented")
    }
}