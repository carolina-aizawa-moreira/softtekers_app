package com.fiap.softtekers.repository

import com.fiap.softtekers.model.FormAnalisys
import com.fiap.softtekers.model.QuestionAnalisys

fun getAllFormAnalisys(): List<FormAnalisys>{
    return listOf(
        FormAnalisys(
            "Mapeamento de Riscos",
            listOf(
                QuestionAnalisys("Seu emoji", 1.0,   true),
                QuestionAnalisys("Como você sente", 8.4,  false),
            ),
            0
        ),
        FormAnalisys(
            "Fatores de Carga de Trabalho",
            listOf(
                QuestionAnalisys("Carga de Trabalho", 3.0, false),
                QuestionAnalisys("Trabalho afeta sua qualidade de vida", 2.2, false),
                QuestionAnalisys("Trabalho além do seu horário regular", 4.1, false)
            ),
            1
        ),
        FormAnalisys(
            "Sinais de Alerta",
            listOf(
                QuestionAnalisys("Você tem apresentado alterações no sono?", 1.5, false),
                QuestionAnalisys("Você tem sendito irritabilidade ou mudanças de humor?", 4.8, false),
                QuestionAnalisys("Você tem sentido fadiga ou falta de energia?", 3.3, false)
            ),
            1
        ),
        FormAnalisys(
            "Diagnóstico de Clima / Relacionamento",
            listOf(
                QuestionAnalisys("Como você avalia a comunicação com sua equipe?", 1.8, false),
                QuestionAnalisys("Você se sente à vontade para dar e receber feedback?", 3.1, false),
                QuestionAnalisys("Como você avalia o relacionamento com seus colegas?", 4.9, false)
            ),
            2
        )
    )
}