package com.fiap.softtekers.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComoSenteScreen(navController: NavController) {
    // ✅ Lista de opções
    val opcoes = listOf("Motivado", "Cansado", "Preocupado", "Estressado", "Animado")
    var selecionado by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Check-in",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF2563EB),
                    titleContentColor = Color.White
                ),
                actions = {
                    TextButton(onClick = { navController.navigate("home") }) {
                        Text("Pular", color = Color.White)
                    }
                }
            )
        },
        containerColor = Color(0xFF2563EB)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                // 🔵 Pergunta principal
                Text(
                    text = "Como você se sente hoje?",
                    fontSize = 55.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 32.dp)
                )

                // 🔵 Lista de opções
                opcoes.forEach { opcao ->
                    val selecionadoItem = (opcao == selecionado)

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .background(
                                if (selecionadoItem) Color(0xFF004DFF).copy(alpha = 0.4f)
                                else Color.Transparent
                            )
                            .clickable { selecionado = opcao }
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = opcao,
                            fontSize = 24.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.weight(1f)
                        )
                        RadioButton(
                            selected = selecionadoItem,
                            onClick = { selecionado = opcao },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color(0xFF00EFD2), // ✅ bolinha selecionada na cor pedida
                                unselectedColor = Color.White
                            )
                        )
                    }
                }
            }

            // 🔵 Botão final
            Button(
                onClick = { navController.navigate("home") },
                enabled = selecionado != null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00EFD2),      // ✅ cor quando habilitado
                    contentColor = Color.Black,              // ✅ texto preto
                    disabledContainerColor = Color(0xFF00EFD2).copy(alpha = 0.5f), // ✅ cor quando desabilitado
                    disabledContentColor = Color.Black.copy(alpha = 0.5f)
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    "Ir para o app",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }


        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ComoSentePreview() {
    val navController = rememberNavController()
    ComoSenteScreen(navController = navController)
}
