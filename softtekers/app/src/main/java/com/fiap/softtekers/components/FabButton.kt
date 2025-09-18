package com.fiap.softtekers.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fiap.softtekers.R

@Composable
fun FabButton(navController: NavController) {
    Box() {
        FloatingActionButton(
            onClick = { /* stub */ },
            shape = RoundedCornerShape(18.dp),
            containerColor = MaterialTheme.colorScheme.tertiary,
            contentColor = Color.Black,
            modifier = Modifier
                .align(Alignment.Center)
                .size(90.dp)
                .offset(y = 96.dp)
                .drawBehind {
                    drawRoundRect(
                        color = Color(red = 0.6f, green = 0.6f, blue = 0.6f, alpha = 0.25f),
                        cornerRadius = CornerRadius(18.dp.toPx()),
                        style = Stroke(width = 12.dp.toPx())
                    )
                }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_you),
                contentDescription = "Você",
                modifier = Modifier.size(64.dp)
            )
        }
    }
}
