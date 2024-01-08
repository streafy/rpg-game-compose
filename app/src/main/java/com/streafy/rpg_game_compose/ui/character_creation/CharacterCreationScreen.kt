package com.streafy.rpg_game_compose.ui.character_creation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.streafy.rpg_game_compose.ui.AppViewModelProvider
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterCreationScreen(
    navigateBack: () -> Unit,
    viewModel: CharacterCreationViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val state = viewModel.state.collectAsStateWithLifecycle()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = state.value.name,
            onValueChange = viewModel::onNameChanged,
            label = { Text(text = "Name") },
            isError = !state.value.isValid,
        )
        Button(onClick = {
            coroutineScope.launch {
                viewModel.createCharacter()
                navigateBack()
            }
        }) {
            Text(text = "Create")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterCreationScreenPreview() {
    CharacterCreationScreen({})
}