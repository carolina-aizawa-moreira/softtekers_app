package com.fiap.softtekers.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fiap.softtekers.ui.theme.YouTertiary

@Composable

fun LoginScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(MaterialTheme.colorScheme.surface.value))
            .padding(20.dp)
    ) {
        Text(text = "Você em primeiro lugar.", style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.tertiary)
        Text(text = "Programa de apoio à saúde mental e psicossocial dos Softtekers")
        Button(
            onClick = {
                navController.navigate("checkIn")
            },
            colors = ButtonDefaults.buttonColors(YouTertiary)
        ) {
            Text(text = "Entrar")
        }
    }
}

annotation class LoginScreen
