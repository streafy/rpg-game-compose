package com.streafy.rpg_game_compose.data

import com.streafy.rpg_game_compose.domain.entity.game.player.PlayerCharacter
import com.streafy.rpg_game_compose.domain.repository.PlayerCharacterRepository

class PlayerCharacterRepositoryImpl : PlayerCharacterRepository {

    private val mockData = List(10) {
        PlayerCharacter(name = "Character $it", healthPoints = 100)
    }

    override fun getCharacters(): List<PlayerCharacter> =
        mockData
}