package com.fiap.softtekers.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            title = { Text(currentRoute.toString(),fontSize = 14.sp) },
            colors = TopAppBarDefaults.topAppBarColors(
                titleContentColor = MaterialTheme.colorScheme.onPrimary
            ),
            actions = {
                if (currentRoute == "checkIn" || currentRoute == "formSente") {
                    Button(
                        onClick = {
                            navController.navigate("home")
                        }
                    ) {
                        Text(text = "Pular")
                    }
                }
            }
        )
        HorizontalDivider(color = Color(red = 1.0f, green = 1.0f, blue = 1.0f, alpha = 0.15f), thickness = 1.dp)
    }
}
