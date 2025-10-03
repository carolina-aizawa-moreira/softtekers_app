package com.fiap.softtekers.model

data class Form(
    val title: String,
    val questions: List<Question>,
    val route: String
)
