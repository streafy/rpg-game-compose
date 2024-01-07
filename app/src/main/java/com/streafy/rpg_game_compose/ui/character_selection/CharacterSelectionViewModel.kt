package com.streafy.rpg_game_compose.ui.character_selection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.streafy.rpg_game_compose.domain.entity.characters_screen.Character
import com.streafy.rpg_game_compose.domain.entity.game.player.PlayerCharacter
import com.streafy.rpg_game_compose.domain.repository.PlayerCharacterRepository
import com.streafy.rpg_game_compose.domain.usecase.GetPlayerCharacterListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CharacterSelectionViewModel(
    repository: PlayerCharacterRepository
) : ViewModel() {

    private val getPlayerCharacterListUseCase = GetPlayerCharacterListUseCase(repository)

    private val _state = MutableStateFlow<List<Character>>(listOf())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            collectCharacters()
        }
    }

    private suspend fun collectCharacters() {
        getPlayerCharacterListUseCase().collect {
            _state.value = it.toCharacterList()
        }
    }

    private fun List<PlayerCharacter>.toCharacterList(): List<Character> =
        map { Character(it.name, it.level) }
}