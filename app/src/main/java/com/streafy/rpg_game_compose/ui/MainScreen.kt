package com.streafy.rpg_game_compose.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.streafy.rpg_game_compose.domain.entity.characters_screen.Character
import com.streafy.rpg_game_compose.navigation.AppNavHost
import com.streafy.rpg_game_compose.navigation.Screen
import com.streafy.rpg_game_compose.ui.game.GameScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    AppNavHost(
        navHostController = navController,
        homeScreenContent = {
            HomeScreen { navController.navigate(Screen.CharacterSelection.route) }
        },
        characterSelectionScreenContent = {
            val mockData = List(30) {
                Character("Character $it ", 1)
            }
            CharacterSelectionScreen(characters = mockData) {
                navController.navigate(Screen.Game.route)
            }
        },
        gameScreenContent = {
            GameScreen()
        }
    )
}
