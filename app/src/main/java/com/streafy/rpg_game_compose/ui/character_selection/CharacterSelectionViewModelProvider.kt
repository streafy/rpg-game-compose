package com.streafy.rpg_game_compose.ui.character_selection

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.streafy.rpg_game_compose.RgpGameComposeApplication

object CharacterSelectionViewModelProvider {

    val Factory = viewModelFactory {
        initializer {
            CharacterSelectionViewModel(rpgGameComposeApplication().container.playerCharacterRepository)
        }
    }
}

fun CreationExtras.rpgGameComposeApplication(): RgpGameComposeApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as RgpGameComposeApplication)