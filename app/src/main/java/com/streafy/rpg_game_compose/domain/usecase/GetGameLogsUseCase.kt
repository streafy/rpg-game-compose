package com.streafy.rpg_game_compose.domain.usecase

import com.streafy.rpg_game_compose.domain.entity.game.Game
import com.streafy.rpg_game_compose.domain.entity.game.logger.LogEntry

class GetGameLogsUseCase(
    private val game: Game
) {

    operator fun invoke(): List<LogEntry> =
        game.gameLogs
}