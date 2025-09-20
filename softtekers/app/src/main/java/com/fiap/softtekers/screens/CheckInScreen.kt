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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class EmojiOption(val emoji: String, val label: String, val value: String)

val emojiOptions = listOf(
    EmojiOption("😊", "Alegre", "alegre"),
    EmojiOption("😟", "Triste", "triste"),
    EmojiOption("😩", "Cansado", "cansado"),
    EmojiOption("😤", "Ansioso", "ansioso"),
    EmojiOption("😱", "Medo", "medo"),
)

@Composable
fun CheckInScreen(navController: NavController) {
    var selectedEmoji by remember { mutableStateOf<EmojiOption?>(null) }

    // Removido Scaffold e TopAppBar para eliminar menu superior

    // Fundo e conteúdo organizados dentro do Column diretamente
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2563EB))
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            // Pergunta principal
            Column(modifier = Modifier.padding(bottom = 24.dp)) {
                Text(
                    text = "Já escolheu o",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "seu emoji de hoje?",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }


            // Lista de emojis com seleção
            emojiOptions.forEach { option ->
                val isSelected = option == selectedEmoji
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .background(
                            if (isSelected) Color(0xFF004DFF).copy(alpha = 0.4f)
                            else Color.Transparent
                        )
                        .clickable { selectedEmoji = option }
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = option.emoji,
                        fontSize = 32.sp,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                    Text(
                        text = option.label,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White,
                        modifier = Modifier.weight(1f)
                    )
                    RadioButton(
                        selected = isSelected,
                        onClick = { selectedEmoji = option },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color(0xFF00EFD2),
                            unselectedColor = Color.White
                        )
                    )
                }
            }
        }

        // Botão próximo
        Button(
            onClick = { navController.navigate("home") },
            enabled = selectedEmoji != null,
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00EFD2),
                contentColor = Color.Black,
                disabledContainerColor = Color(0xFF00EFD2).copy(alpha = 0.5f),
                disabledContentColor = Color.Black.copy(alpha = 0.5f)
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                "Próximo",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
