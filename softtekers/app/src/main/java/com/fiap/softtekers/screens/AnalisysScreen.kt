package com.fiap.softtekers.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AnalisysScreen(navController: NavController){
    Column(
        modifier = androidx.compose.ui.Modifier
            .padding(20.dp)
    ) {
        Text("Analisys Screen")
    }
}