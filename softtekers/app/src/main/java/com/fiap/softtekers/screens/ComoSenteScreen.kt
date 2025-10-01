package com.fiap.softtekers.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

val opcoes = listOf("Motivado", "Cansado", "Preocupado", "Estressado", "Animado")

@Composable
fun ComoSenteScreen(navController: NavController) {
    // ✅ Lista de opções
    var selecionado by remember { mutableStateOf<String?>(null) }

    // Fundo e conteúdo organizados dentro do Column diretamente
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .weight(1f) // This makes the Column take available vertical space
                .padding(20.dp, 0.dp)
                .verticalScroll(rememberScrollState()),
        ) {
            // Pergunta principal
            Row(
                modifier = Modifier
                    .padding(bottom = 24.dp)
            ) {
                Text(
                    text = "Como você se sente hoje?",
                    fontSize = 40.sp,
                    lineHeight = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            // 🔵 Lista de opções
            opcoes.forEach { opcao ->
                val selecionadoItem = (opcao == selecionado)

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
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
        HorizontalDivider(
            color = Color(
                red = 1.0f,
                green = 1.0f,
                blue = 1.0f,
                alpha = 0.15f
            ), thickness = 1.dp
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(20.dp, 10.dp)
                .fillMaxWidth()
        ) {
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
                shape = RoundedCornerShape(4.dp)
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