package com.fiap.softtekers.screens.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.fiap.softtekers.repository.getAllForms
import com.fiap.softtekers.screens.homescreen.components.CardCarrousel


//todo: acrescentar navController

@Composable
fun HomeScreen(navController: NavController) {

    var formsListState by remember {
        mutableStateOf(getAllForms())
    }


    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFF1948FF),
            )
    ) {
        items(formsListState){
            CardCarrousel(form = it, it.route, navController)
        }
    }
}