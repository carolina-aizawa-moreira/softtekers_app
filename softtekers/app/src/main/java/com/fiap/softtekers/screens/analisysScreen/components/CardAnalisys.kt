package com.fiap.softtekers.screens.analisysScreen.components

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fiap.softtekers.model.EmojiOption
import com.fiap.softtekers.model.QuestionAnalisys
import com.fiap.softtekers.repository.getAllEmojis
import com.fiap.softtekers.ui.theme.YouPrimary


@Composable
fun CardAnalisys(question: QuestionAnalisys, scaleType: Int? = 0) {

    Card(
        border = BorderStroke(0.dp, Color.Transparent),
        colors = CardDefaults.cardColors(
            containerColor = YouPrimary
        ),
        modifier = Modifier
            .padding(end = 8.dp)
            .border(
                width = 1.dp,
                color = Color(0xFFDEDFE6),
                shape = RoundedCornerShape(16.dp)
            )
            .height(150.dp)
            .width(150.dp)
            .clip(shape = RoundedCornerShape(16.dp))
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            if (question.icon!!) {
                Text(
                    text = getScaleEmoji(question.score!!).emoji,
                    fontSize = 32.sp
                )
                Spacer(modifier = Modifier.weight(1f))
            }
            // Use a Spacer with weight to push the content upwards
            Text(
                question.title!!,
                color = Color.White,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
            )
            // Use a Spacer with weight to push the content upwards
            Spacer(modifier = Modifier.weight(1f))
            Column{
                if (scaleType != 0) {
                    Text(
                        text = question.score!!.toString(),
                        //TODO: mudar cor do texto de acordo com a escala: Muito Leve,Leve,Média,Alta,Muito Alta
                        color = getScale(question.score, scaleType).color,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(end = 2.dp)
                    )
                }
                Text(
                    text = "("+getScale(question.score!!, scaleType).text+")",
                    color = Color.White,
                    style = MaterialTheme.typography.bodySmall,
                    fontStyle = FontStyle.Italic,
                )
            }
        }
    }

}

data class AnalisysStatus(val color:Color, val text:String);
fun getScale(score: Double, scaleType: Int? = 0): AnalisysStatus {
    return when (scaleType) {
        null -> AnalisysStatus(Color(0xFF7A7A7A), "Sem resposta")
        0 -> { // Escala 0
            when (score) {
                in 0.0..2.5 -> AnalisysStatus(Color(0xFF4CAF50), "Neutro") // Neutro
                in 2.6..5.0 -> AnalisysStatus(Color(0xFFFFEB3B), "Leve") // Leve
                in 5.1..7.50 -> AnalisysStatus(Color(0xFFFF9800), "Moderado") // Moderado
                in 7.6..10.0 -> AnalisysStatus(Color(0xFFF44336), "Agudo") // Agudo
                else -> Color.White
            }
        }
        1 -> { // Escala 1
            when (score) {
                in 0.0..2.0 -> AnalisysStatus(Color(0xFF4CAF50), "Muito Leve") // Muito Leve
                in 2.1..4.0 -> AnalisysStatus(Color(0xFF8BC34A), "Leve") // Leve
                in 4.1..6.0 -> AnalisysStatus(Color(0xFFFFEB3B), "Média") // Média
                in 6.1..8.0 -> AnalisysStatus(Color(0xFFFF9800), "Alta") // Alta
                in 8.1..10.0 -> AnalisysStatus(Color(0xFFF44336), "Muito Alta") // Muito Alta
                else -> Color.White
            }
        }
        2 -> { // Escala 1
            when (score) {
                in 1.0..2.4 -> AnalisysStatus(Color(0xFFF44336), "Atenção") // Atenção
                in 2.5..3.4 -> AnalisysStatus(Color(0xFFFFEB3B), "Zona de Alerta") // Zona de Alerta
                in 3.5..5.0 -> AnalisysStatus(Color(0xFF4CAF50), "Ambiente Saudável") // Ambiente Saudável
                else -> Color.White
            }
        }
        else -> AnalisysStatus(Color(0xFF4CAF50), "Neutro") // Cor padrão para tipos de escala não reconhecidos
    } as AnalisysStatus
}

fun getScaleEmoji(score: Double): EmojiOption {
    return when (score) {
        in 0.0..2.0 -> getAllEmojis()[0] // Muito Leve
        in 2.1..4.0 -> getAllEmojis()[1]// Leve
        in 4.1..6.0 -> getAllEmojis()[2]// Média
        in 6.1..8.0 -> getAllEmojis()[3] // Alta
        in 8.1..10.0 -> getAllEmojis()[4]
        else -> getAllEmojis()[0]
    }
}

