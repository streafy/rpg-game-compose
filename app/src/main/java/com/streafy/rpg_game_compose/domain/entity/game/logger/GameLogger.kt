package com.streafy.rpg_game_compose.domain.entity.game.logger

import java.time.LocalTime

class GameLogger {

    val logs: MutableList<LogEntry> = mutableListOf()

    fun addLogEntry(eventText: String) {
        logs.add(LogEntry(LocalTime.now(), eventText))
    }
}

class LogEntry(
    private val eventTime: LocalTime,
    private val eventText: String
) {

    override fun toString(): String {
        val formattedEventTime = String.format("%02d:%02d", eventTime.hour, eventTime.minute)
        return "[$formattedEventTime] $eventText"
    }
}