package com.streafy.rpg_game_compose.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerCharacterDao {

    @Query("SELECT * FROM player_character")
    fun getAllItems(): Flow<List<PlayerCharacter>>

    @Query("SELECT * FROM player_character WHERE id = :id")
    fun getItem(id: Int): Flow<PlayerCharacter>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(character: PlayerCharacter)

    @Update
    suspend fun update(character: PlayerCharacter)

    @Delete
    suspend fun delete(character: PlayerCharacter)
}