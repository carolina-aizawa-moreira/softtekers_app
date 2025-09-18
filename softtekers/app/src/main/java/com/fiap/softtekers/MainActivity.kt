package com.fiap.softtekers

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults.contentWindowInsets
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.zIndex
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.fiap.softtekers.components.BottomNavBar
import com.fiap.softtekers.components.FabButton
import com.fiap.softtekers.components.TopNavBar
import com.fiap.softtekers.screens.AnalisysScreen
import com.fiap.softtekers.screens.CheckInScreen
import com.fiap.softtekers.screens.ComoSenteScreen
import com.fiap.softtekers.screens.DiagnosticoRelacionamentoScreen
import com.fiap.softtekers.screens.FormularioAnonimoScreen
import com.fiap.softtekers.screens.HomeScreen
import com.fiap.softtekers.screens.LoginScreen
import com.fiap.softtekers.screens.SinaisDeAlertaScreen
import com.fiap.softtekers.ui.theme.SofttekersTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SofttekersTheme {
                val navController = rememberNavController()
                // Observe the current back stack entry
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                val showTopBar = when (currentRoute) {
                    "login" -> false // Show on these screens
                    else -> true // Hide on other screens (e.g., "login")
                }
                val showBottomBar = when (currentRoute) {
                    "login", "checkIn",  -> false // Show on these screens
                    else -> true // Hide on other screens (e.g., "login")
                }
                Scaffold(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    contentWindowInsets = contentWindowInsets,
                    floatingActionButton = {
                        if (showBottomBar) {
                            FabButton(navController)
                        }
                    },
                    floatingActionButtonPosition = FabPosition.Center,
                    topBar = {
                        if (showTopBar) {
                            TopNavBar(navController = navController)
                        }
                    },
                    bottomBar = {
                        if (showBottomBar) {
                            BottomNavBar(navController = navController)
                        }
                    }

                ) { innerPadding: PaddingValues ->
                    NavHost(
                        navController = navController,
                        startDestination = "login",
                        modifier = Modifier
                            .fillMaxSize() // Fill the available space
                            .padding(innerPadding) // <-- APPLY the PaddingValues here
                    ){
                        composable("login") {
                            LoginScreen(navController)
                        }
                        composable("home") {
                            HomeScreen(navController)
                        }
                        composable("checkIn") {
                            CheckInScreen(navController)
                        }
                        composable("analisys"){
                            AnalisysScreen(navController)
                        }
                        composable("formSinais") {
                            Dialog(
                                onDismissRequest = {} ,
                                DialogProperties(
                                    usePlatformDefaultWidth = false
                                )
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(Color.Black)
                                        .zIndex(10F),
                                    contentAlignment = Alignment.Center
                                ) {
                                    SinaisDeAlertaScreen(navController)
                                }
                            }
                        }
                        composable("formClima") {
                            Dialog(
                                onDismissRequest = {},
                                DialogProperties(
                                    dismissOnBackPress = true,
                                    usePlatformDefaultWidth = false
                                )
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(Color.Black)
                                        .zIndex(10F),
                                    contentAlignment = Alignment.Center
                                ) {
                                    DiagnosticoRelacionamentoScreen(navController)
                                }
                            }
                        }
                        composable("formCarga") {
                            Dialog(
                                onDismissRequest = {},
                                DialogProperties(
                                    dismissOnBackPress = true,
                                    usePlatformDefaultWidth = false
                                )
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(Color.Black)
                                        .zIndex(10F),
                                    contentAlignment = Alignment.Center
                                ) {
                                    FormularioAnonimoScreen(navController)
                                }
                            }
                        }
                        composable("formSente") {
                            Dialog(
                                onDismissRequest = {},
                                DialogProperties(
                                    dismissOnBackPress = true,
                                    usePlatformDefaultWidth = false
                                )
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(Color.Black)
                                        .zIndex(10F),
                                    contentAlignment = Alignment.Center
                                ) {
                                    ComoSenteScreen(navController)
                                }
                            }
                        }


                    }
                }
            }
        }
    }
}
