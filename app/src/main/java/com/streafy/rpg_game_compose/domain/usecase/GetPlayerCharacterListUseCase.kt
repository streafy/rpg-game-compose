package com.streafy.rpg_game_compose.domain.usecase

import com.streafy.rpg_game_compose.domain.repository.PlayerCharacterRepository

class GetPlayerCharacterListUseCase(
    private val repository: PlayerCharacterRepository
) {

    operator fun invoke() =
        repository.getCharacters()
}