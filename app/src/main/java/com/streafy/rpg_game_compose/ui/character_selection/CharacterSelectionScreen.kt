package com.streafy.rpg_game_compose.ui.character_selection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.streafy.rpg_game_compose.domain.entity.characters_screen.Character
import com.streafy.rpg_game_compose.ui.theme.RpgGameComposeTheme

@Composable
fun CharacterSelectionScreen(
    viewModel: CharacterSelectionViewModel = viewModel(factory = CharacterSelectionViewModelProvider.Factory),
    onCharacterClick: () -> Unit
) {
    val characters by viewModel.state.collectAsStateWithLifecycle()

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterCard(
    character: Character,
    onCharacterClick: () -> Unit
) {
    Card(
        onClick = onCharacterClick,
        modifier = Modifier
            .padding(horizontal = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
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
    RpgGameComposeTheme {
        CharacterSelectionScreen() {}
    }
}