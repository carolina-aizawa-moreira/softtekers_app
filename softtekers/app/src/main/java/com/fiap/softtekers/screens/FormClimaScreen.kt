package com.fiap.softtekers.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.fiap.softtekers.components.PerguntaDropdown

// ---------- PREVIEW ----------
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DiagnosticoRelacionamentoPreview() {
    val navController = rememberNavController()
    DiagnosticoRelacionamentoScreen(navController = navController)
}

// ---------- TELA ----------
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiagnosticoRelacionamentoScreen(navController: NavController) {
    var resposta1 by remember { mutableStateOf("") }
    var resposta2 by remember { mutableStateOf("") }
    var resposta3 by remember { mutableStateOf("") }
    var mensagem by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Formulário Anônimo",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black,
                    titleContentColor = Color.White
                ),
                actions = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Fechar",
                            tint = Color.White
                        )
                    }
                }
            )
        },
        containerColor = Color.Black
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(20.dp)
        ) {
            // 🔵 Título principal
            Text(
                text = "Diagnóstico de Clima Relacionamento",
                fontSize = 37.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5A73FC),
                modifier = Modifier.padding(bottom = 24.dp)
            )

            // Pergunta 1
            PerguntaDropdown(
                titulo = "Como você avalia a comunicação com sua equipe?",
                resposta = resposta1,
                onSelect = { resposta1 = it },
                opcoes = listOf("Muito ruim", "Ruim", "Regular", "Boa", "Excelente"),
                modifier = Modifier.padding(vertical = 10.dp)
            )

            // Pergunta 2
            PerguntaDropdown(
                titulo = "Você se sente à vontade para dar e receber feedback?",
                resposta = resposta2,
                onSelect = { resposta2 = it },
                opcoes = listOf("Nunca", "Raramente", "Às vezes", "Frequentemente", "Sempre"),
                modifier = Modifier.padding(vertical = 10.dp)
            )

            // Pergunta 3
            PerguntaDropdown(
                titulo = "Como você avalia o relacionamento com seus colegas?",
                resposta = resposta3,
                onSelect = { resposta3 = it },
                opcoes = listOf("Muito ruim", "Ruim", "Regular", "Bom", "Excelente"),
                modifier = Modifier.padding(vertical = 10.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            // 🔵 Botão enviar
            Button(
                onClick = { mensagem = "Formulário enviado com sucesso!" },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF1A5CFF))
            ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Enviar",
                    tint = Color.White
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    "Enviar",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            if (mensagem.isNotEmpty()) {
                Spacer(Modifier.height(16.dp))
                Text(mensagem, color = Color.White)
            }
        }
    }
}
