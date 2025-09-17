package com.fiap.softtekers.components
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Column {
        HorizontalDivider(color = Color.White, thickness = 1.dp)
        BottomAppBar(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.tertiary,
            contentPadding = BottomAppBarDefaults.ContentPadding
        ) {
            IconButton(
                onClick = {
                    navController.navigate("home")
                },
                modifier = Modifier
                    .weight(1f)
                    .background(
                        if (currentRoute == "home") {
                            MaterialTheme.colorScheme.surfaceContainerLowest
                        } else {
                            Color.Transparent
                        }
                    )
            ) {
                Icon(
                    Icons.Outlined.Home,
                    contentDescription = "Início",
                    modifier = Modifier.size(32.dp)
                )
            }
            Box(
                modifier = Modifier
                    .weight(2f),
                contentAlignment = Alignment.Center
            ) {

                FloatingActionButton(
                    onClick = {
//                Toast.makeText(
//                    context,
//                    "Você clicou no botão de ação!",
//                    Toast.LENGTH_SHORT
//                ).show()
                    },
                    containerColor = MaterialTheme.colorScheme.tertiary,
                    contentColor = Color.Black,
                ) {
                    Icon(
                        Icons.Outlined.Search,
                        contentDescription = "Você",
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
            IconButton(
                onClick = { navController.navigate("analisys") },
                modifier = Modifier
                    .weight(1f)
                    .background(
                        if (currentRoute == "analisys") {
                            MaterialTheme.colorScheme.surfaceContainerLowest
                        } else {
                            Color.Transparent
                        }
                    )
            ) {
                Icon(
                    Icons.Outlined.Favorite,
                    contentDescription = "Análise",
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}