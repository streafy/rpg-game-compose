package com.streafy.rpg_game_compose.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.streafy.rpg_game_compose.domain.entity.characters_screen.Character
import com.streafy.rpg_game_compose.ui.theme.RpgGameComposeTheme

@Composable
fun CharacterSelectionScreen(
    characters: List<Character>,
    onCharacterClick: () -> Unit
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(text = "Character List", fontSize = 36.sp)
        }
        items(characters) { character ->
            CharacterCard(
                character = character,
                onCharacterClick = onCharacterClick
            )
        }
        item {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Create New Character")
            }
        }
    }
}

@Composable
fun CharacterCard(
    character: Character,
    onCharacterClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .clickable { onCharacterClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = character.name)
            Text(text = "Level: ${character.level}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterSelectionScreenPreview() {
    val mockData = List(10) {
        Character("Character $it ", 1)
    }

    RpgGameComposeTheme {
        CharacterSelectionScreen(characters = mockData) {}
    }
}