package com.streafy.rpg_game_compose.ui.game

import androidx.lifecycle.ViewModel
import com.streafy.rpg_game_compose.domain.entity.game.GameImpl
import com.streafy.rpg_game_compose.domain.entity.game.logger.LogEntry
import com.streafy.rpg_game_compose.domain.entity.game.player.PlayerCharacter
import com.streafy.rpg_game_compose.domain.entity.game_screen.Creature
import com.streafy.rpg_game_compose.domain.repository.PlayerCharacterRepository
import com.streafy.rpg_game_compose.domain.usecase.GetGameLogsUseCase
import com.streafy.rpg_game_compose.domain.usecase.GetPlayerCharacterUseCase
import com.streafy.rpg_game_compose.domain.usecase.PlayerAttackUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

data class GameUiState(
    val player: PlayerCharacter,
    val currentEnemy: Creature,
    val gameLogs: List<LogEntry>
)

class GameViewModel(
    repository: PlayerCharacterRepository
) : ViewModel() {

    val getPlayerCharacterUseCase = GetPlayerCharacterUseCase(repository)

    private val initialPlayer = PlayerCharacter("initial", 999)

    private var game = GameImpl(initialPlayer)

    var playerAttackUseCase = PlayerAttackUseCase(game)
    var getGameLogsUseCase = GetGameLogsUseCase(game)

    private val _state = MutableStateFlow(
        GameUiState(
            player = initialPlayer,
            currentEnemy = Creature("Ogre", 40),
            gameLogs = listOf()
        )
    )
    val state = _state.asStateFlow()

    suspend fun fetchPlayerCharacterById(id: Int) {
        getPlayerCharacterUseCase(id).collect {
            _state.value = _state.value.copy(player = it)
            game = GameImpl(it)
            playerAttackUseCase = PlayerAttackUseCase(game)
            getGameLogsUseCase = GetGameLogsUseCase(game)
        }
    }

    fun onAttackButtonClick() {
        val enemy = playerAttackUseCase()
        val logs = getGameLogsUseCase()
        _state.value = _state.value.copy(currentEnemy = enemy, gameLogs = logs)
    }
}