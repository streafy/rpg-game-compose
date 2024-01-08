package com.streafy.rpg_game_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun AppNavHost(
    navHostController: NavHostController,
    homeScreenContent: @Composable () -> Unit,
    characterSelectionScreenContent: @Composable () -> Unit,
    characterCreationScreenContent: @Composable () -> Unit,
    gameScreenContent: @Composable (Int) -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            homeScreenContent()
        }
        composable(Screen.CharacterSelection.route) {
            characterSelectionScreenContent()
        }
        composable(Screen.CharacterCreation.route) {
            characterCreationScreenContent()
        }
        composable(
            Screen.Game.route,
            arguments = listOf(navArgument(Screen.KEY_CHARACTER_ID) { type = NavType.IntType })
        ) {
            val id = it.arguments?.getInt(Screen.KEY_CHARACTER_ID)
                ?: throw RuntimeException("Character id is null")
            gameScreenContent(id)
        }
    }
}