package com.streafy.rpg_game_compose.domain.entity.game.creature

import com.streafy.rpg_game_compose.domain.entity.game.item.Item
import kotlin.random.Random

interface Fightable {

    val name: String

    var healthPoints: Int
    val isAlive
        get() = healthPoints > 0

    val baseDamage: Int
    val diceCount: Int
    val diceSides: Int

    /**
     * Describes how Fightable takes damage
     * @param damage damage Fightable should take without any damage reductions
     * @return Actual damage taken by the Fightable with all damage reductions.
     * It cannot be greater than the Fightable remaining health
     */
    fun takeDamage(damage: Int): Int {
        healthPoints -= damage
        val actualDamage = if (healthPoints < 0) {
            damage + healthPoints
        } else {
            damage
        }
        return actualDamage
    }

    /**
     * Attacks target and deals [baseDamage + 0 - (diceCount * diceSides)] damage
     * @param target Fightable that will take damage
     * @return Actual damage taken by the target Fightable with all damage reductions.
     * It cannot be greater than the target Fightable remaining health
     */
    fun attack(target: Fightable): Int {
        val damageRoll = (0 until diceCount).sumOf {
            Random.nextInt(diceSides + 1)
        }
        return target.takeDamage(baseDamage + damageRoll)
    }
}

interface Lootable {

    val loot: List<Item>
}

abstract class Monster(
    override val name: String,
    val description: String,
    override var healthPoints: Int
) : Fightable {


}

class Goblin(
    name: String = "Goblin",
    description: String = "A nasty-looking goblin",
    healthPoints: Int = 40
) : Monster(name, description, healthPoints) {

    override val baseDamage: Int = 5
    override val diceCount: Int = 2
    override val diceSides: Int = 6
}