package com.streafy.rpg_game_compose.domain.repository

import com.streafy.rpg_game_compose.domain.entity.game.player.PlayerCharacter
import kotlinx.coroutines.flow.Flow

interface PlayerCharacterRepository {

    fun getCharacters(): Flow<List<PlayerCharacter>>

    fun getCharacter(id: Int): Flow<PlayerCharacter>

    suspend fun insertCharacter(character: PlayerCharacter)

    suspend fun updateCharacter(character: PlayerCharacter)

    suspend fun deleteCharacter(character: PlayerCharacter)
}