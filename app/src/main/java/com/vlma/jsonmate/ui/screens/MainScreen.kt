package com.vlma.jsonmate.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vlma.jsonmate.ui.components.HeaderBar

@Composable
fun MainScreen(onNavigateToSettings: () -> Unit) {
    // In React: const [jsonText, setJsonText] = useState("")
    var jsonText by remember { mutableStateOf("") }

    // Scaffold is the standard "Page Layout" in Android
    Scaffold(
        topBar = {
            HeaderBar(
                title = "JSONMate",
                onSettingsClick = onNavigateToSettings,
                onBackClick = null // No back button on home
            )
        },
        floatingActionButton = {
            // Your SpeedDialFab code would go here
            ExtendedFloatingActionButton(
                onClick = { /* Handle Format logic */ },
                text = { Text("Format") },
                icon = { Text("{ }") }
            )
        }
    ) { innerPadding ->
        // innerPadding handles the space taken by the TopBar
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Enter JSON below:",
                style = MaterialTheme.typography.labelLarge
            )
            Spacer(modifier = Modifier.height(8.dp))

            // TextField is like <textarea> in React
            OutlinedTextField(
                value = jsonText,
                onValueChange = { jsonText = it },
                modifier = Modifier.fillMaxSize(),
                placeholder = { Text("Paste your JSON here...") }
            )
        }
    }
}