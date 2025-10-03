package com.fiap.softtekers.repository

import com.fiap.softtekers.model.EmojiOption

fun getAllEmojis(): List<EmojiOption>{
    return listOf(
        EmojiOption("😊", "Alegre", "alegre"),
        EmojiOption("😟", "Triste", "triste"),
        EmojiOption("😩", "Cansado", "cansado"),
        EmojiOption("😤", "Ansioso", "ansioso"),
        EmojiOption("😱", "Medo", "medo"),
        )
}