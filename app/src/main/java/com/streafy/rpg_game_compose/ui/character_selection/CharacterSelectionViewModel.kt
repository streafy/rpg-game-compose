package com.streafy.rpg_game_compose.ui.character_selection

import androidx.lifecycle.ViewModel
import com.streafy.rpg_game_compose.data.PlayerCharacterRepositoryImpl
import com.streafy.rpg_game_compose.domain.entity.characters_screen.Character
import com.streafy.rpg_game_compose.domain.usecase.GetPlayerCharacterListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CharacterSelectionViewModel : ViewModel() {

    private val repository = PlayerCharacterRepositoryImpl()
    private val getPlayerCharacterListUseCase = GetPlayerCharacterListUseCase(repository)

    private val _state = MutableStateFlow<List<Character>>(listOf())
    val state = _state.asStateFlow()

    init {
        loadCharacters()
    }

    private fun loadCharacters() {
        _state.value = getPlayerCharacterListUseCase().map { Character(it.name, it.level) }
    }
}