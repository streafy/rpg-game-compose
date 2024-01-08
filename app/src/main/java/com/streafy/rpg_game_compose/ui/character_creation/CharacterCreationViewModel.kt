package com.streafy.rpg_game_compose.ui.character_creation

import androidx.lifecycle.ViewModel
import com.streafy.rpg_game_compose.domain.entity.game.player.PlayerCharacter
import com.streafy.rpg_game_compose.domain.repository.PlayerCharacterRepository
import com.streafy.rpg_game_compose.domain.usecase.CreateCharacterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CharacterCreationViewModel(
    repository: PlayerCharacterRepository
) : ViewModel() {

    private val createCharacterUseCase = CreateCharacterUseCase(repository)

    private val _state = MutableStateFlow(CharacterCreationUiState())
    val state = _state.asStateFlow()

    fun onNameChanged(name: String) {
        _state.value = state.value.copy(name = name)
    }

    suspend fun createCharacter() {
        if (validateInput()) {
            createCharacterUseCase(PlayerCharacter(_state.value.name, 100))
        }
    }

    private fun validateInput(name: String = _state.value.name): Boolean {
        val isValid = name.isNotBlank() && name.doNotContainsDigits()
        _state.value = _state.value.copy(isValid = isValid)
        return isValid
    }

    private fun String.doNotContainsDigits(): Boolean {
        val pattern = Regex("\\d")
        return !pattern.containsMatchIn(this)
    }
}

data class CharacterCreationUiState(
    val name: String = "",
    val isValid: Boolean = true
)