package com.fiap.softtekers.model
//import com.google.gson.annotations.SerializedName
data class Form(
    val title: String,
    val questions: List<Question>,
    val route: String

//    @SerializedName("logradouro") val rua: String = "",
//    @SerializedName("localidade") val cidade: String = "",
)


