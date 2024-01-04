package com.streafy.rpg_game_compose.ui.game

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.streafy.rpg_game_compose.domain.entity.game.logger.LogEntry
import com.streafy.rpg_game_compose.ui.theme.RpgGameComposeTheme

@Composable
fun GameScreen(viewModel: GameViewModel = viewModel()) {
    val state = viewModel.state.collectAsState()
    val player = state.value.player
    val enemy = state.value.currentEnemy
    val logs = state.value.gameLogs
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Box(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .background(Color.Red)
            )
            Box(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .background(Color.Blue)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CreatureCard(player.name, player.health, 100)
            CreatureCard(enemy.name, enemy.health, 40)
        }
        Row {
            Button(onClick = viewModel::onAttackButtonClick) {
                Text(text = "Attack")
            }
            val context = LocalContext.current
            Button(onClick = {
                Toast.makeText(context, "Not implemented yet", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "Defend")
            }
        }
        CombatLog(logs)
    }
}

@Composable
fun CreatureCard(name: String, currentHealth: Int, maxHealth: Int) {
    Card(

    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = name)
            val healthRatio = currentHealth.toFloat() / maxHealth
            HealthBar(healthRatio = healthRatio)
        }
    }
}

@Composable
fun HealthBar(healthRatio: Float) {
    val color = when {
        healthRatio >= 0.7 -> Color.Green
        healthRatio >= 0.4 -> Color.Yellow
        else -> Color.Red
    }

    val width = healthRatio * 150

    Box(
        modifier = Modifier
            .width(150.dp)
            .height(30.dp)
            .border(BorderStroke(1.dp, Color.Black)),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(width.dp)
                .background(color, shape = RoundedCornerShape(2.dp))
                .align(Alignment.CenterStart),
        )
        Text(
            text = "${(healthRatio * 100).toInt()}%",
            color = Color.Black
        )
    }

}

@Composable
fun CombatLog(logs: List<LogEntry>) {
    Card {
        LazyColumn(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .padding(8.dp)
        ) {
            items(logs) {
                Text(
                    text = it.toString()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    RpgGameComposeTheme {
        GameScreen()
    }
}