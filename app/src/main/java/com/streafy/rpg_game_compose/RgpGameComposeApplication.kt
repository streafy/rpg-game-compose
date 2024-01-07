package com.streafy.rpg_game_compose

import android.app.Application
import com.streafy.rpg_game_compose.di.AppContainer
import com.streafy.rpg_game_compose.di.AppDataContainer

class RgpGameComposeApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}