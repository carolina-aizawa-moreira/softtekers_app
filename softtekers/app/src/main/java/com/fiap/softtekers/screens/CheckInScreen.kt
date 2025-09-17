package com.fiap.softtekers.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.fiap.softtekers.ui.theme.YouTertiary
import java.lang.reflect.Modifier

@Composable
fun CheckInScreen(navController: NavController){
    Column(
        modifier = androidx.compose.ui.Modifier
            .padding(20.dp)
    ) {
        Text(
            "Já escolheu o seu emoji de hoje?",
            style = MaterialTheme.typography.headlineLarge
        )
        Button(
            onClick = {
                navController.navigate("home")
            },
            colors = ButtonDefaults.buttonColors(YouTertiary)

        ) {
            Text(text = "Proximo")
        }
    }
}