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
        playerCharacterDao.getAllItems().mapToDomainList()

    override fun getCharacter(id: Int): Flow<PlayerCharacter> =
        playerCharacterDao.getItem(id).mapToDomain()

    override suspend fun insertCharacter(character: PlayerCharacter) {
        playerCharacterDao.insert(character.toRoomPlayerCharacter())
    }

    override suspend fun updateCharacter(character: PlayerCharacter) {
        playerCharacterDao.update(character.toRoomPlayerCharacter())
    }

    override suspend fun deleteCharacter(character: PlayerCharacter) {
        playerCharacterDao.delete(character.toRoomPlayerCharacter())
    }

    private fun Flow<List<RoomPlayerCharacter>>.mapToDomainList(): Flow<List<PlayerCharacter>> =
        map { list -> list.map { it.toDomain() } }

    private fun Flow<RoomPlayerCharacter>.mapToDomain(): Flow<PlayerCharacter> =
        map { it.toDomain() }

    private fun PlayerCharacter.toRoomPlayerCharacter(): RoomPlayerCharacter =
        RoomPlayerCharacter(id, name, healthPoints, baseDamage, diceCount, diceSides, level)

    private fun RoomPlayerCharacter.toDomain(): PlayerCharacter =
        PlayerCharacter(name, healthPoints, id)
}