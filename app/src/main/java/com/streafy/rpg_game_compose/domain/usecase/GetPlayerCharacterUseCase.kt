package com.streafy.rpg_game_compose.domain.usecase

import com.streafy.rpg_game_compose.domain.entity.game.player.PlayerCharacter
import com.streafy.rpg_game_compose.domain.repository.PlayerCharacterRepository
import kotlinx.coroutines.flow.Flow

class GetPlayerCharacterUseCase(
    private val repository: PlayerCharacterRepository
) {

    operator fun invoke(id: Int): Flow<PlayerCharacter> =
        repository.getCharacter(id)
}