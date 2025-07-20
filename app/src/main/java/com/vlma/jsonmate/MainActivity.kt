package com.vlma.jsonmate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import com.vlma.jsonmate.ui.*
import com.vlma.jsonmate.ui.theme.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var isDarkTheme by remember { mutableStateOf(false) }

            JSONMateTheme(darkTheme = isDarkTheme) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(
                        isDarkTheme = isDarkTheme,
                        onThemeToggle = { isDarkTheme = !isDarkTheme }
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    isDarkTheme: Boolean,
    onThemeToggle: () -> Unit
) {
    Scaffold(
        topBar = {
            HeaderBar(
                isDarkTheme = isDarkTheme,
                onThemeToggle = onThemeToggle
            )
        },
        containerColor = MaterialTheme.colorScheme.primary,

        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* TODO: Add logic */ },
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = MaterialTheme.colorScheme.onSecondary
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add",
                    modifier = Modifier.size(32.dp)
                )
            }
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = ". . .",
                    color = MaterialTheme.colorScheme.onPrimary,
                )
            }
        }
    )
}