package com.fiap.softtekers.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController){
    Column(
        modifier = androidx.compose.ui.Modifier
            .padding(20.dp)
    ) {
        Text("Mapeamento de Riscos")
        Button(
            onClick = { navController.navigate("formSente") },
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
        ) {
            Text("Responder")
        }


        Text("Fatores de Carga de Trabalho")
        Button(
            onClick = { navController.navigate("formCarga") }
        ) {
            Text("Responder")
        }

        Text("Sinais de Alerta")
        Button(
            onClick = { navController.navigate("formSinais") }
        ) {
            Text("Responder")
        }

        Text("Diagnostico de Clima / Relacionamento")
        Button(
            onClick = { navController.navigate("formClima") }
        ) {
            Text("Responder")
        }
    }
}