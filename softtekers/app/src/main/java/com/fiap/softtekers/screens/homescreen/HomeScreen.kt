package com.fiap.softtekers.screens.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.consultacep.service.RetrofitFactory
import com.fiap.softtekers.model.Form
import com.fiap.softtekers.repository.getAllForms
import com.fiap.softtekers.screens.homescreen.components.CardQuestionCarrousel
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavController) {

    var formsListState by remember {
        mutableStateOf(listOf<Form>())
    }

    LaunchedEffect(Unit) {
        launch {
            try {
                val forms = RetrofitFactory().getHomeService().getAllFroms()
                formsListState = forms
            } catch (e: Exception) {
                formsListState = getAllForms()
            }
        }
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xFF1948FF),
            ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(formsListState){ form ->
            CardQuestionCarrousel(form = form, navController = navController)
        }
    }
}


