package com.streafy.rpg_game_compose.ui.game

import androidx.lifecycle.ViewModel
import com.streafy.rpg_game_compose.domain.entity.game.GameImpl
import com.streafy.rpg_game_compose.domain.entity.game.logger.LogEntry
import com.streafy.rpg_game_compose.domain.entity.game_screen.Creature
import com.streafy.rpg_game_compose.domain.usecase.GetGameLogsUseCase
import com.streafy.rpg_game_compose.domain.usecase.PlayerAttackUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class GameUiState(
    val player: Creature,
    val currentEnemy: Creature,
    val gameLogs: List<LogEntry>
)

class GameViewModel : ViewModel() {

    val game = GameImpl()

    val playerAttackUseCase = PlayerAttackUseCase(game)
    val getGameLogsUseCase = GetGameLogsUseCase(game)

    private val _state = MutableStateFlow(
        GameUiState(
            player = Creature("streezy", 100),
            currentEnemy = Creature("Ogre", 40),
            gameLogs = listOf()
        )
    )
    val state: StateFlow<GameUiState>
        get() = _state

    fun onAttackButtonClick() {
        val enemy = playerAttackUseCase()
        val logs = getGameLogsUseCase()
        _state.value = _state.value.copy(currentEnemy = enemy, gameLogs = logs)
    }
}