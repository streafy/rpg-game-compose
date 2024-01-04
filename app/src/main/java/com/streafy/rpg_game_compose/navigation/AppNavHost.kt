package com.streafy.rpg_game_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavHost(
    navHostController: NavHostController,
    homeScreenContent: @Composable () -> Unit,
    characterSelectionScreenContent: @Composable () -> Unit,
    gameScreenContent: @Composable () -> Unit
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
        composable(Screen.Game.route) {
            gameScreenContent()
        }
    }
}