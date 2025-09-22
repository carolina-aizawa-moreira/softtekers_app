package com.fiap.softtekers.screens.homescreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DefaultCards(texto : String?) {
    val cardText = texto ?: "Default"
    OutlinedButton(
        onClick = { println("Pressed!") },
        border = BorderStroke(0.dp, Color.Transparent),
        colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent),
        contentPadding = PaddingValues(),
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color(0xFFDEDFE6),
                shape = RoundedCornerShape(16.dp)
            )
            .width(140.dp)
            .height(134.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .background(
                color = Color(0xFFFFFFFF),
                shape = RoundedCornerShape(16.dp)
            ),
    ) {
        Column(
            modifier = Modifier
                .width(112.dp)
                .height(106.dp),
        ) {
            Text(
                text = cardText,
                color = Color(0xFF1948FF),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
            )
            //todo: Texto precisa ser dinamico passado via props
            Text(
                "Não respondido",
                color = Color.Black,
                fontSize = 12.sp,
                fontWeight = FontWeight.W300,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 6.dp)
            )
        }
    }
}


@Composable
@Preview(showBackground = false)
fun DefaultCardsPreview() {
    DefaultCards("Carga de Trabalho")
}