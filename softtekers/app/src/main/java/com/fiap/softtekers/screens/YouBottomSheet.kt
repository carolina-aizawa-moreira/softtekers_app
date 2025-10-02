package com.fiap.softtekers.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fiap.softtekers.R
import com.fiap.softtekers.ui.theme.YouPrimary
import com.fiap.softtekers.ui.theme.YouShade
import com.fiap.softtekers.ui.theme.YouTertiary

@Composable
fun YouBottomSheet(){

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(
                contentAlignment = androidx.compose.ui.Alignment.Center,
                modifier = Modifier
                    .size(90.dp)
                    .drawBehind {
                        drawRoundRect(
                            color = Color(red = 0.6f, green = 0.6f, blue = 0.6f, alpha = 0.25f),
                            cornerRadius = CornerRadius(18.dp.toPx()),
                            style = Stroke(width = 12.dp.toPx())
                        )
                    }
                    .fillMaxSize()
                    .clip(RoundedCornerShape(18.dp))
                    .background(YouTertiary)

            ) {
                Icon(
                    tint = Color.Black,
                    painter = painterResource(id = R.drawable.icon_you),
                    contentDescription = "Você",
                    modifier = Modifier.size(64.dp)
                )
            }

        }
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 16.dp)
        ) {
            Text("Dicas")
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = YouShade
                ),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                    modifier = Modifier.padding(16.dp)

                ) {
                    Icon(
                        tint = YouTertiary,
                        painter = painterResource(id = R.drawable.icon_meditation),
                        contentDescription = "Você",
                        modifier = Modifier.size(38.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text("Meditação pode ajudar a melhorar seus indices. Pratique todo os dias pelo menos 30 min.")
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = YouShade
                ),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Icon(
                        tint = YouTertiary,
                        painter = painterResource(id = R.drawable.icon_run),
                        contentDescription = "Você",
                        modifier = Modifier.size(38.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text("Fazer esportes pode te ajudar a melhorar o humor e pode ajudar a conhecer pessoas novas")
                }
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(YouPrimary)
            .padding(16.dp, 0.dp)

    ){
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 16.dp)
        ) {
            Text("Estamos aqui para te ajudar")
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(165.dp)
                .padding(0.dp, 16.dp),

        ){
            Card(
                border = BorderStroke(0.dp, Color.Transparent),
                colors = CardDefaults.cardColors(
                    containerColor = YouPrimary
                ),
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = Color(0xFFDEDFE6),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .weight(1F)
                    .clip(shape = RoundedCornerShape(16.dp))
            ) {
                Column (
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Icon(
                        tint = YouTertiary,
                        painter = painterResource(id = R.drawable.icon_callout),
                        contentDescription = "Você",
                        modifier = Modifier.size(24.dp)
                    )
                    Text("Fazer uma ligação anônima ")
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Card(
                border = BorderStroke(0.dp, Color.Transparent),
                colors = CardDefaults.cardColors(
                    containerColor = YouPrimary
                ),
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = Color(0xFFDEDFE6),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .weight(1F)
                    .clip(shape = RoundedCornerShape(16.dp))
            ) {
                Column (
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Icon(
                        tint = YouTertiary,
                        painter = painterResource(id = R.drawable.icon_chat),
                        contentDescription = "Você",
                        modifier = Modifier.size(24.dp)
                    )
                    Text("Enviar uma mensagem anônima")
                }
            }
        }
    }
}