package com.streafy.rpg_game_compose.domain.entity.game

import com.streafy.rpg_game_compose.domain.entity.game.creature.Fightable
import com.streafy.rpg_game_compose.domain.entity.game.logger.LogEntry
import com.streafy.rpg_game_compose.domain.entity.game_screen.Creature

interface Game {

    val gameLogs: List<LogEntry>

    fun handlePlayerAttack(): Fightable

    fun handleEnemyAttack(): Fightable
}