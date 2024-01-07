package com.streafy.rpg_game_compose.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player_character")
data class PlayerCharacter(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    @ColumnInfo(name = "health_points")
    val healthPoints: Int,
    @ColumnInfo(name = "base_damage")
    val baseDamage: Int,
    @ColumnInfo(name = "dice_count")
    val diceCount: Int,
    @ColumnInfo(name = "dice_sides")
    val diceSides: Int,
    val level: Int
)