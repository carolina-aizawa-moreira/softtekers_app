package com.fiap.softtekers.model

data class FormAnalisys(
    val title: String,
    val questions: List<QuestionAnalisys>,
    val scaleType: Number? = null,
)
