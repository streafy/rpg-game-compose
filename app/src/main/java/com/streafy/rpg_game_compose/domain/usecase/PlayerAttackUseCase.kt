package com.streafy.rpg_game_compose.domain.usecase

import com.streafy.rpg_game_compose.domain.entity.game.Game
import com.streafy.rpg_game_compose.domain.entity.game_screen.Creature

class PlayerAttackUseCase(
    private val game: Game
) {

    operator fun invoke(): Creature {
        val enemy = game.handlePlayerAttack()
        return Creature(enemy.name, enemy.healthPoints)
    }
}