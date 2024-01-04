package com.streafy.rpg_game_compose.domain.entity.game.player

import com.streafy.rpg_game_compose.domain.entity.game.creature.Fightable

class Player(
    override val name: String,
    override var healthPoints: Int
) : Fightable {

    override val baseDamage: Int = 10
    override val diceCount: Int = 3
    override val diceSides: Int = 8

    private val baseArmor = 2

    override fun takeDamage(damage: Int): Int {
        val actualDamage = damage - baseArmor
        healthPoints -= actualDamage
        return actualDamage
    }
}