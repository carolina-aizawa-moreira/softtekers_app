package com.fiap.softtekers.screens.homescreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CargaDeTrabalho() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFF1948FF),
            )
            .padding(top = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(bottom = 20.dp)
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 20.dp)
            ) {
                Text(
                    "Fatores de Carga de Trabalho",
                    color = Color(0xFFF0F2FA),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(end = 72.dp)
                        .weight(1f)
                )
                OutlinedButton(
                    //todo: colocar rota do form para
                    onClick = { println("Pressed!") },
                    border = BorderStroke(0.dp, Color.Transparent),
                    colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(),
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = Color(0x00FFFFFF),
                            shape = RoundedCornerShape(6.dp)
                        )
                        .clip(shape = RoundedCornerShape(6.dp))
                        .background(
                            color = Color(0x00FFFFFF),
                            shape = RoundedCornerShape(6.dp)
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .padding(vertical = 7.dp, horizontal = 13.dp)
                    ) {
                        Text(
                            "Responder",
                            color = Color(0xFF00EFD2),
                            fontSize = 16.sp,
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp)
            ) {
                Column(modifier = Modifier.padding(end = 4.dp)) {
                    DefaultCards("Carga de Trabalho")
                }
                Column(modifier = Modifier.padding(end = 4.dp)) {
                    DefaultCards("Trabalho afeta sua qualidade de vida")
                }

            }
        }
    }
}


@Composable
@Preview(showBackground = false)
fun CargaDeTrabalhoPreview() {
    CargaDeTrabalho()
}