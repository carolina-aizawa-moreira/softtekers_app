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
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import com.fiap.softtekers.R

@Composable
fun BottomNavBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Column {
        HorizontalDivider(color = Color(red = 1.0f, green = 1.0f, blue = 1.0f, alpha = 0.15f), thickness = 1.dp)
        BottomAppBar(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.tertiary,
            contentPadding = PaddingValues(25.dp,0.dp,),
            modifier = Modifier.height(120.dp).heightIn(min = 0.dp)
        ) {
            IconButton(
                onClick = {
                    navController.navigate("home")
                },
                modifier = Modifier
                    .weight(1f)
                    .height(120.dp)
                    .background(
                        if (currentRoute == "home") {
                            Color(red = 0.0f, green = 0.0f, blue = 0.0f, alpha = 0.15f)
                        } else {
                            Color.Transparent
                        }
                    )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_home),
                    contentDescription = "Início",
                    modifier = Modifier.size(32.dp)
                )
            }
            Box(
                modifier = Modifier
                    .weight(2f)
                ,
                contentAlignment = Alignment.Center
            ){}
            IconButton(
                onClick = { navController.navigate("analisys") },
                modifier = Modifier
                    .weight(1f)
                    .height(120.dp)
                    .background(
                        if (currentRoute == "analisys") {
                            Color(red = 0.0f, green = 0.0f, blue = 0.0f, alpha = 0.15f)
                        } else {
                            Color.Transparent
                        }
                    )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_heart),
                    contentDescription = "Análise",
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}