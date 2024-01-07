package com.streafy.rpg_game_compose.data

import com.streafy.rpg_game_compose.data.room.PlayerCharacterDao
import com.streafy.rpg_game_compose.domain.entity.game.player.PlayerCharacter
import com.streafy.rpg_game_compose.domain.repository.PlayerCharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.streafy.rpg_game_compose.data.room.PlayerCharacter as RoomPlayerCharacter

class PlayerCharacterRepositoryImpl(
    private val playerCharacterDao: PlayerCharacterDao
) : PlayerCharacterRepository {

    override fun getCharacters(): Flow<List<PlayerCharacter>> =
        playerCharacterDao.getAllItems().mapToDomain()

    private fun Flow<List<RoomPlayerCharacter>>.mapToDomain(): Flow<List<PlayerCharacter>> =
        map { list -> list.map { PlayerCharacter(it.name, it.healthPoints) } }
}