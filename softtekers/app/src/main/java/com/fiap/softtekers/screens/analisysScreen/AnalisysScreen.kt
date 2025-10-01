package com.fiap.softtekers.screens.analisysScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fiap.softtekers.R
import com.fiap.softtekers.screens.analisysScreen.components.AnalisysCardCarrousel
import com.fiap.softtekers.screens.homescreen.Form
import com.fiap.softtekers.screens.homescreen.Question
import com.fiap.softtekers.screens.homescreen.data
import com.fiap.softtekers.ui.theme.YouTertiary

data class Form(val title: String, val questions: List<Question>, val route: String)
data class Question(val title: String?, val answer: String?, val icon: Boolean?)

val data = listOf(
    Form(
        "Mapeamento de Riscos",
        listOf(
            Question("Seu emoji hoje", "", true),
            Question("Como você sente hoje?", "", false),
        ),
        "formCarga"
    ),
    Form(
        "Fatores de Carga de Trabalho",
        listOf(
            Question("Carga de Trabalho", "", false),
            Question("Trabalho afeta sua qualidade de vida", "", false),
            Question("Trabalho além do seu horário regular", "", false)
        ),
        "formCarga"
    ),
    Form(
        "Sinais de Alerta",
        listOf(
            Question("Você tem apresentado alterações no sono?", "", false),
            Question("Você tem sendito irritabilidade ou mudanças de humor?", "", false),
            Question("Você tem sentido fadiga ou falta de energia?", "", false)
        ),
        "formSinais"
    ),
    Form(
        "Diagnóstico de Clima / Relacionamento",
        listOf(
            Question("Como você avalia a comunicação com sua equipe?", "", false),
            Question("Você se sente à vontade para dar e receber feedback?", "", false),
            Question("Como você avalia o relacionamento com seus colegas?", "", false)
        ),
        "formClima"
    )
)
@Composable
fun AnalisysScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .background(
                color = Color(0xFF1948FF),
            )
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, bottom = 20.dp)

        ){
            Icon(
                painter = painterResource(id = R.drawable.icon_heart),
                contentDescription = "Análise",
                modifier = Modifier.size(32.dp),
                tint = YouTertiary
            )
        }
        data.forEach { form ->
            AnalisysCardCarrousel(form.title, form.questions )
        }

    }
}