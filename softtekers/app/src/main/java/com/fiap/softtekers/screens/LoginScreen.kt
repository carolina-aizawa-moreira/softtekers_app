package com.fiap.softtekers.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fiap.softtekers.R
import com.fiap.softtekers.ui.theme.YouTertiary

@Composable

fun LoginScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(MaterialTheme.colorScheme.surface.value))
            .paint(  painterResource(id = R.drawable.background), contentScale = ContentScale.Crop)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Image(
            painter = painterResource(id = R.drawable.softtek_brand),
                contentDescription = "You Brand",
                modifier = Modifier.width(120.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.you_brand),
                contentDescription = "You Brand"
            )
            Spacer(modifier = Modifier.padding(16.dp))
            Text(text = "Você em primeiro lugar.",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.tertiary,

            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = "Programa de apoio à saúde mental e psicossocial dos Softtekers",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White,
            )
            Spacer(modifier = Modifier.padding(8.dp))
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
}

annotation class LoginScreen
