package com.streafy.rpg_game_compose.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room

@Database(entities = [PlayerCharacter::class], version = 1)
abstract class GameDatabase : androidx.room.RoomDatabase() {

    abstract fun playerCharacterDao(): PlayerCharacterDao

    companion object {

        @Volatile
        private var Instance: GameDatabase? = null

        fun getDatabase(context: Context): GameDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, GameDatabase::class.java, "game_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}