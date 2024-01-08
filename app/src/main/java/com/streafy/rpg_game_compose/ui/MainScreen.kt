package com.streafy.rpg_game_compose.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.streafy.rpg_game_compose.navigation.AppNavHost
import com.streafy.rpg_game_compose.navigation.Screen
import com.streafy.rpg_game_compose.ui.character_creation.CharacterCreationScreen
import com.streafy.rpg_game_compose.ui.character_selection.CharacterSelectionScreen
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
            CharacterSelectionScreen(
                onCharacterClick = {
                    navController.navigate(Screen.Game.route)
                },
                onCreateCharacterButtonClicked = { navController.navigate(Screen.CharacterCreation.route) }
            )
        },
        characterCreationScreenContent = {
            CharacterCreationScreen(navigateBack = { navController.popBackStack() })
        },
        gameScreenContent = {
            GameScreen()
        }
    )
}
