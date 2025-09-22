package com.fiap.softtekers.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview(showBackground = true)
fun Header(title: String?) {
    val header = title ?: "Header Title Default"
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(color = Color(0xFF1948FF))
            .border(width = 2.dp, color = Color(0x26FFFFFF), shape = RectangleShape),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .height(21.dp)
                .fillMaxWidth()
                .align(alignment = Alignment.CenterHorizontally),

            text = header,
            color = Color(0xFFDEE2E6),
            fontSize = 14.sp,
            lineHeight = 21.sp,
            fontWeight = FontWeight.Bold
        )
    }
}