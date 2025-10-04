package com.fiap.softtekers.screens.homescreen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
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
import com.fiap.softtekers.screens.homescreen.components.CardQuestionCarrousel
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavController) {

    // This state will hold the list of forms fetched from the API
    var formsListState by remember {
        mutableStateOf(listOf<Form>())
    }

    // LaunchedEffect is used to run a side-effect (like a network call)
    // when the composable is first displayed.
    // The key `Unit` means this effect will run only once.\

    // In D:/workspaces2/softtekers/app/src/main/java/com/fiap/softtekers/screens/homescreen/HomeScreen.kt


    // ... inside your HomeScreen composable

    LaunchedEffect(Unit) {
        // 'launch' is optional here since LaunchedEffect provides a scope,
        // but it can be good for clarity.
        launch {
            try {
                // Call the suspend function directly
                val forms = RetrofitFactory().getHomeService().getAllFroms()
                formsListState = forms
            } catch (e: Exception) {
                // Handle any network or parsing exceptions
                Log.e("API_ERROR", "Failed to fetch forms: ${e.message}", e)
            }
        }
    }



    LazyColumn(
        modifier = Modifier
            .fillMaxSize() // Use fillMaxSize to cover the whole screen
            .background(
                color = Color(0xFF1948FF),
            ),
        contentPadding = PaddingValues(16.dp), // Use contentPadding for spacing
        verticalArrangement = Arrangement.spacedBy(16.dp) // Adds space between items
    ) {
        items(formsListState){ form ->
            CardQuestionCarrousel(form = form, navController = navController)
        }
    }
}


