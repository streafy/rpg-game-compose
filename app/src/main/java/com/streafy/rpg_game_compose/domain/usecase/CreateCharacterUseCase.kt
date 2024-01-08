package com.streafy.rpg_game_compose.domain.usecase

import com.streafy.rpg_game_compose.domain.entity.game.player.PlayerCharacter
import com.streafy.rpg_game_compose.domain.repository.PlayerCharacterRepository

class CreateCharacterUseCase(
    private val repository: PlayerCharacterRepository
) {

    suspend operator fun invoke(character: PlayerCharacter) =
        repository.insertCharacter(character)
}