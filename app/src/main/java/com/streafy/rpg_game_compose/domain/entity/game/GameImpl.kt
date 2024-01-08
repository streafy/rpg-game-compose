package com.streafy.rpg_game_compose.domain.entity.game

import com.streafy.rpg_game_compose.domain.entity.game.creature.Fightable
import com.streafy.rpg_game_compose.domain.entity.game.creature.Goblin
import com.streafy.rpg_game_compose.domain.entity.game.location.Location
import com.streafy.rpg_game_compose.domain.entity.game.logger.GameLogger
import com.streafy.rpg_game_compose.domain.entity.game.player.PlayerCharacter

class GameImpl(
    private var player: PlayerCharacter
) : Game {

    private var enemy = Goblin()

    private var currentLocation = Location("Stating location")

    private val gameLogger = GameLogger()

    override val gameLogs
        get() = gameLogger.logs.toList()

    override fun handlePlayerAttack(): Fightable {
        val damageTaken = player.attack(enemy)

        gameLogger.addLogEntry(
            "${player.name} attacked ${enemy.name} " +
                    "and dealt $damageTaken damage"
        )

        if (!enemy.isAlive) {
            gameLogger.addLogEntry("${player.name} killed ${enemy.name}")
            enemy = Goblin()
        }

        return enemy
    }

    override fun handleEnemyAttack(): Fightable {
        val damageTaken = enemy.attack(player)

        gameLogger.addLogEntry(
            "${enemy.name} attacked ${player.name} " +
                    "and dealt $damageTaken damage"
        )

        return player
    }
}