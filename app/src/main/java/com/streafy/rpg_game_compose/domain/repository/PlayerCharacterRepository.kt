package com.streafy.rpg_game_compose.domain.repository

import com.streafy.rpg_game_compose.domain.entity.game.player.PlayerCharacter

interface PlayerCharacterRepository {

    fun getCharacters(): List<PlayerCharacter>
}