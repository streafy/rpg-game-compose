package com.streafy.rpg_game_compose.ui

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.streafy.rpg_game_compose.RgpGameComposeApplication
import com.streafy.rpg_game_compose.ui.character_creation.CharacterCreationViewModel
import com.streafy.rpg_game_compose.ui.character_selection.CharacterSelectionViewModel
import com.streafy.rpg_game_compose.ui.game.GameViewModel

object AppViewModelProvider {

    val Factory = viewModelFactory {
        initializer {
            CharacterSelectionViewModel(rpgGameComposeApplication().container.playerCharacterRepository)
        }
        initializer {
            CharacterCreationViewModel(rpgGameComposeApplication().container.playerCharacterRepository)
        }
        initializer {
            GameViewModel(rpgGameComposeApplication().container.playerCharacterRepository)
        }
    }
}

fun CreationExtras.rpgGameComposeApplication(): RgpGameComposeApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as RgpGameComposeApplication)