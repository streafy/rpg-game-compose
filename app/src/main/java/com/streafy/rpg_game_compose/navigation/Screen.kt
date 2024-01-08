package com.streafy.rpg_game_compose.navigation

sealed class Screen(
    val route: String
) {

    object Home : Screen(ROUTE_HOME)
    object CharacterSelection : Screen(ROUTE_CHARACTER_SELECTION)
    object CharacterCreation : Screen(ROUTE_CHARACTER_CREATION)
    object Game : Screen(ROUTE_GAME) {

        private const val ROUTE = "game"

        fun getRouteWithArgs(id: Int): String = "$ROUTE/$id"
    }

    companion object {

        const val KEY_CHARACTER_ID = "character_id"

        const val ROUTE_HOME = "home"
        const val ROUTE_CHARACTER_SELECTION = "character_selection"
        const val ROUTE_CHARACTER_CREATION = "character_creation"
        const val ROUTE_GAME = "game/{$KEY_CHARACTER_ID}"
    }
}