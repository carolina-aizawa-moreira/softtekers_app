package com.fiap.softtekers.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults.contentWindowInsets
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.fiap.softtekers.components.PerguntaDropdown
import com.fiap.softtekers.ui.theme.YouPrimarySubtle

// ---------- COMPOSABLE PRINCIPAL ----------
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SinaisDeAlertaPreview() {
    val navController = rememberNavController()
    SinaisDeAlertaScreen(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SinaisDeAlertaScreen(navController: NavController) {
    var resposta1 by remember { mutableStateOf("") }
    var resposta2 by remember { mutableStateOf("") }
    var resposta3 by remember { mutableStateOf("") }
    var mensagem by remember { mutableStateOf("") }

    Scaffold(
        containerColor = Color.Black,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        contentWindowInsets = contentWindowInsets,
        topBar = {

            Column {
                TopAppBar(
                    title = {
                        Text(
                            "Formulário Anônimo",
                            style = MaterialTheme.typography.bodyMedium,
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
                HorizontalDivider(
                    color = Color(
                        red = 1.0f,
                        green = 1.0f,
                        blue = 1.0f,
                        alpha = 0.15f
                    ), thickness = 1.dp
                )
            }
        },
        bottomBar = {

            Column {
                HorizontalDivider(
                    color = Color(
                        red = 1.0f,
                        green = 1.0f,
                        blue = 1.0f,
                        alpha = 0.15f
                    ), thickness = 1.dp
                )
                BottomAppBar(
                    containerColor = Color.Black,
                    contentPadding = PaddingValues(25.dp, 0.dp,),
                    modifier = Modifier.heightIn(min = 0.dp)
                ) { // 🔵 Botão enviar (simulação)
                    Button(
                        onClick = {
                            // Simulação de envio
                            mensagem = "Formulário enviado com sucesso!"
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFF1A5CFF)),
                        shape = RoundedCornerShape(10.dp)
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
                            style = MaterialTheme.typography.bodyLarge, // 🔹 aumenta aqui (ex: 20sp, pode testar 22sp também)
                            fontWeight = FontWeight.Light // 🔹 opcional: deixa em negrito
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(20.dp, 0.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // 🔵 Título principal
            Spacer(modifier = Modifier.height(40.dp).fillMaxWidth())
            Text(
                text = "Sinais de Alerta",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Normal,
                color = YouPrimarySubtle,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            // Pergunta 1
            PerguntaDropdown(
                title = "Você tem apresentado alterações no sono?",
                answer = resposta1,
                onSelect = { resposta1 = it },
                options = listOf("Nunca", "Raramente", "Às vezes", "Frequentemente", "Sempre"),
                modifier = Modifier.padding(vertical = 10.dp)
            )

            // Pergunta 2
            PerguntaDropdown(
                title = "Você tem sentido irritabilidade ou mudanças de humor?",
                answer = resposta2,
                onSelect = { resposta2 = it },
                options = listOf("Nunca", "Raramente", "Às vezes", "Frequentemente", "Sempre"),
                modifier = Modifier.padding(vertical = 10.dp)
            )

            // Pergunta 3
            PerguntaDropdown(
                title = "Você tem sentido fadiga ou falta de energia?",
                answer = resposta3,
                onSelect = { resposta3 = it },
                options = listOf("Nunca", "Raramente", "Às vezes", "Frequentemente", "Sempre"),
                modifier = Modifier.padding(vertical = 10.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            if (mensagem.isNotEmpty()) {
                Toast.makeText(LocalContext.current, mensagem, Toast.LENGTH_SHORT).show()
            }

        }
    }
}
