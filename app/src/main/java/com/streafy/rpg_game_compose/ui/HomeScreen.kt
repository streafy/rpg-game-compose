package com.streafy.rpg_game_compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.streafy.rpg_game_compose.ui.theme.RpgGameComposeTheme

@Composable
fun HomeScreen(
    onNavigateToCharacterSelectionScreen: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Rpg Game", fontSize = 36.sp)
        Button(
            onClick = { onNavigateToCharacterSelectionScreen() },
            Modifier.fillMaxWidth(0.5f)
        ) {
            Text(text = "Start game")
        }
        Button(
            onClick = { /*TODO*/ },
            Modifier.fillMaxWidth(0.5f)
        ) {
            Text(text = "Settings")
        }
        Button(
            onClick = { /*TODO*/ },
            Modifier.fillMaxWidth(0.5f)
        ) {
            Text(text = "Exit")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    RpgGameComposeTheme {
        HomeScreen {}
    }
}