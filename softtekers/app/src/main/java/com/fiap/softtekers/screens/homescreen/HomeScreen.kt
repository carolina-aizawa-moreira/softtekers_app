package com.fiap.softtekers.screens.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fiap.softtekers.screens.homescreen.components.CargaDeTrabalho
import com.fiap.softtekers.screens.homescreen.components.MapeamentoDeRiscos

//todo: acrescentar navController
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                color = Color(0xFF1948FF),
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .align(Alignment.CenterHorizontally),
        ) {
            Text(
                "Início",
                color = Color.LightGray,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 24.dp, bottom = 24.dp, start = 20.dp)
            )
            MapeamentoDeRiscos()

            Column() {
                CargaDeTrabalho()
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen()
}


//    Column(
//        modifier = androidx.compose.ui.Modifier
//            .padding(20.dp)
//    ) {
//        Text("Mapeamento de Riscos")
//        Button(
//            onClick = { navController.navigate("formSente") },
//            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
//        ) {
//            Text("Responder")
//        }
//
//
//        Text("Fatores de Carga de Trabalho")
//        Button(
//            onClick = { navController.navigate("formCarga") }
//        ) {
//            Text("Responder")
//        }
//
//        Text("Sinais de Alerta")
//        Button(
//            onClick = { navController.navigate("formSinais") }
//        ) {
//            Text("Responder")
//        }
//
//        Text("Diagnostico de Clima / Relacionamento")
//        Button(
//            onClick = { navController.navigate("formClima") }
//        ) {
//            Text("Responder")
//        }
//    }
