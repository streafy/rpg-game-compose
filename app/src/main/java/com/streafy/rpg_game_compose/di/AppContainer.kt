package com.streafy.rpg_game_compose.di

import android.content.Context
import com.streafy.rpg_game_compose.data.PlayerCharacterRepositoryImpl
import com.streafy.rpg_game_compose.data.room.GameDatabase
import com.streafy.rpg_game_compose.domain.repository.PlayerCharacterRepository

interface AppContainer {

    val playerCharacterRepository: PlayerCharacterRepository
}

class AppDataContainer(private val context: Context) : AppContainer {

    override val playerCharacterRepository: PlayerCharacterRepository by lazy {
        PlayerCharacterRepositoryImpl(GameDatabase.getDatabase(context).playerCharacterDao())
    }
}