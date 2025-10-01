package com.fiap.softtekers.screens.homescreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.fiap.softtekers.screens.EmojiOption
import com.fiap.softtekers.ui.theme.YouPrimary
val emojiOptions = listOf(
    EmojiOption("😊", "Alegre", "alegre"),
    EmojiOption("😟", "Triste", "triste"),
    EmojiOption("😩", "Cansado", "cansado"),
    EmojiOption("😤", "Ansioso", "ansioso"),
    EmojiOption("😱", "Medo", "medo"),
)
@Composable
fun DefaultCard(title: String, subtitle: String, icon: Boolean, navController: NavController, route: String){
    val ansewered = subtitle.isNotEmpty()

    Card(
        onClick = { navController.navigate(route) },
        border = BorderStroke(0.dp, Color.Transparent),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFFFFF)
        ),
        modifier = Modifier
            .padding(end = 8.dp)
            .border(
                width = 1.dp,
                color = Color(0xFFDEDFE6),
                shape = RoundedCornerShape(16.dp)
            )
            .height(140.dp)
            .width(140.dp)
            .clip(shape = RoundedCornerShape(16.dp))
        ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            if(icon){
                Text(
                    text = emojiOptions[0].emoji,
                    fontSize = 32.sp
                )
                Spacer(modifier = Modifier.weight(1f))
            }
            // Use a Spacer with weight to push the content upwards
            Text(
                title,
                color = YouPrimary,
                fontSize = 14.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
            )
            // Use a Spacer with weight to push the content upwards
            Spacer(modifier = Modifier.weight(1f))
            if(ansewered){
                Text(
                    text = subtitle,
                    //TODO: mudar cor do texto de acordo com a escala: Muito Leve,Leve,Média,Alta,Muito Alta
                    color = YouPrimary,
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }else{
                Text(
                    //todo: o text tem que ser dinamico passado via props
                    text = "não respondido",
                    color = Color.Gray,
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()

                )
            }
        }
    }
}