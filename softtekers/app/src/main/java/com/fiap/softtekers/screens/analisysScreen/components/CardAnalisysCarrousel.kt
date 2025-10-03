package com.fiap.softtekers.screens.analisysScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.fiap.softtekers.model.FormAnalisys

@Composable
fun CardAnalisysCarrousel(
    form: FormAnalisys) {

    val questions = form.questions

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFF1948FF),
            ),

        ) {
        Column(
            modifier = Modifier
                .padding(bottom = 20.dp)
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 20.dp)
            ) {
                Text(
                    form.title,
                    color = Color(0xFFF0F2FA),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .weight(1f)
                        .testTag("formTitle")
                )

            }
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 20.dp)
            ) {
                items( form.questions ) {
                    CardAnalisys(
                        it,

                        form.scaleType as Int?
                    ) // This spacer is now for the space *between* items.
                }
            }

        }
    }
}

