package com.fiap.softtekers.repository

import com.fiap.softtekers.model.Form
import com.fiap.softtekers.model.Question

fun getAllForms(): List<Form> {
    return listOf(
        Form(
            "Mapeamento de Riscos",
            listOf(
                Question("Seu emoji hoje", "oi", true),
                Question("Como você sente hoje?", "oi", false),
            ),
            "checkIn"
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
}