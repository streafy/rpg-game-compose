package com.streafy.rpg_game_compose.navigation

sealed class Screen(
    val route: String
) {

    object Home : Screen(ROUTE_HOME)
    object CharacterSelection : Screen(ROUTE_CHARACTER_SELECTION)
    object Game : Screen(ROUTE_GAME)

    companion object {

        const val ROUTE_HOME = "home"
        const val ROUTE_CHARACTER_SELECTION = "character_selection"
        const val ROUTE_GAME = "game"
    }
}