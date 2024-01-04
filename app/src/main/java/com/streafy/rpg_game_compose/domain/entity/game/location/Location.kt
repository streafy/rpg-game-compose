package com.streafy.rpg_game_compose.domain.entity.game.location

open class Location(val name: String) {

    protected open val status = "Calm"

    open fun description() = "$name (Currently: $status)"

    open fun enterRoom() {

    }
}