package com.fiap.softtekers.screens.analisysScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fiap.softtekers.R
import com.fiap.softtekers.repository.getAllFormAnalisys
import com.fiap.softtekers.screens.analisysScreen.components.CardAnalisysCarrousel
import com.fiap.softtekers.ui.theme.YouTertiary

@Composable
fun AnalisysScreen(navController: NavController){
    var formsListState by remember {
        mutableStateOf(getAllFormAnalisys())
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize() // Use fillMaxSize to cover the whole screen
            .background(
                color = Color(0xFF1948FF),
            )
    ) {
        item {
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
        }

        items(formsListState) { form ->
            CardAnalisysCarrousel(form = form)
        }
    }
}
