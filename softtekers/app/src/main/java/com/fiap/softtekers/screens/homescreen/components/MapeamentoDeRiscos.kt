package com.fiap.softtekers.screens.homescreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage

@Composable
fun MapeamentoDeRiscos() {
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
                    "Mapeamento de Riscos",
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
                OutlinedButton(
                    onClick = { println("Pressed!") },
                    border = BorderStroke(0.dp, Color.Transparent),
                    colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(),
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .border(
                            width = 1.dp,
                            color = Color(0xFFDEDFE6),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .height(134.dp)
                        .width(140.dp)
                        .clip(shape = RoundedCornerShape(16.dp))
                        .background(
                            color = Color(0xFFFFFFFF),
                            shape = RoundedCornerShape(16.dp)
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .width(112.dp)
                            .height(106.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        CoilImage(
                            //todo: aqui deve renderizar o emoji escolhido no check-in e ter um default se nulo
                            imageModel = { "https://storage.googleapis.com/tagjs-prod.appspot.com/v1/bnSXrHTxGc/h5oi5rb1_expires_30_days.png" },
                            imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                            modifier = Modifier
                                .padding(bottom = 8.dp, end = 75.dp)
                                .width(36.dp)
                                .height(35.dp)
                        )
                        Text(
                            "Seu emoji hoje",
                            color = Color(0xFF1948FF),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .width(112.dp)
                                .fillMaxWidth()
                        )
                        Text(
                            //todo: o text tem que ser dinamico passado via props
                            text = "Ansioso",
                            color = Color(0xFFDC3545),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 2.dp)

                        )
                    }
                }
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
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .width(112.dp)
                            .height(106.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            "Como você se sente hoje",
                            color = Color(0xFF1948FF),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .width(112.dp)
                                .height(50.dp)
                        )
                        //todo: Texto precisa ser dinamico passado via props
                        Text(
                            "Estressado",
                            color = Color(0xFFDC3545),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 2.dp)
                        )
                    }
                }
            }
        }
    }
}
