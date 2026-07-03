package com.vlma.jsonmate.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

enum class MainMenu(
    val title: String,
    val description: String,
    val icon: ImageVector? = null
) {
    OPENJSONFILE(
        title = "Open JSON file",
        description = "Open a JSON file from your device",
    ),

    PASTEJSON(
        title = "Paste JSON",
        description = "Paste JSON from clipboard",
    ),

    LOADURL(
        title = "Load URL",
        description = "Load JSON from a URL or API",
    ),

    NEWJSONFILE(
        title = "New JSON file",
        description = "Create a new JSON file",
    )
}

@Composable
fun MainMenu(
    innerPadding: PaddingValues,
) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
    ) {
        items(MainMenu.entries) { menu ->
            Card(
                modifier = Modifier.height(140.dp),
                colors = CardDefaults.cardColors(
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                ) {

                    menu.icon?.let {
                        Icon(
                            imageVector = it,
                            contentDescription = menu.title,
                            modifier = Modifier.size(32.dp)
                        )
                    }

                    Text(
                        text = menu.title,
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                    )

                    Spacer(Modifier.height(4.dp))

                    Text(
                        text = menu.description,
                        style = MaterialTheme.typography.bodySmall,
                    )
                }
            }
        }
    }
}