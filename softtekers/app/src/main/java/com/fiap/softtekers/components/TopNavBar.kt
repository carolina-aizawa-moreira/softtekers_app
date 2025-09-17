package com.fiap.softtekers.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun TopNavBar(navController: NavController) {
    // Get the current back stack entry as a State object
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    // Get the route of the current destination
    val currentRoute = navBackStackEntry?.destination?.route
    Column {
        TopAppBar(
            title = { Text(currentRoute.toString()) },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.onPrimary
            ),
            actions = {
                if (currentRoute == "checkIn") {
                    Button(
                        onClick = {
                            navController.navigate("home")
                        }
                    ) {
                        Text(text = "Pular")
                    }
                }
            },
            modifier = Modifier.drawBehind {
                val strokeWidth = 1.dp.toPx() // Or a fixed value like 1f or 2f
                val y = size.height - strokeWidth / 2 // Position at the bottom

                drawLine(
                    color = Color.White,
                    start = Offset(0f, y),
                    end = Offset(size.width, y),
                    strokeWidth = strokeWidth
                )
            }
        )
        HorizontalDivider(color = Color.White, thickness = 1.dp)
    }
}
