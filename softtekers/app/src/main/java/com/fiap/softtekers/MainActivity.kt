package com.fiap.softtekers

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults.contentWindowInsets
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import com.fiap.softtekers.screens.CheckInScreen
import com.fiap.softtekers.screens.ComoSenteScreen
import com.fiap.softtekers.screens.DiagnosticoRelacionamentoScreen
import com.fiap.softtekers.screens.FormularioAnonimoScreen
import com.fiap.softtekers.screens.LoginScreen
import com.fiap.softtekers.screens.SinaisDeAlertaScreen
import com.fiap.softtekers.screens.YouBottomSheet
import com.fiap.softtekers.screens.analisysScreen.AnalisysScreen
import com.fiap.softtekers.screens.homescreen.HomeScreen
import com.fiap.softtekers.ui.theme.SofttekersTheme
import com.fiap.softtekers.ui.theme.YouPrimaryTranslucid

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SofttekersTheme {


                val navController = rememberNavController()
                var showDialog by remember { mutableStateOf(false) }

                // Sheet state
                var showBottomSheet by remember { mutableStateOf(false) }
                val sheetState = rememberModalBottomSheetState()
                val scope = rememberCoroutineScope()

                // Observe the current back stack entry
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                val showTopBar = when (currentRoute) {
                    "login" -> false // Show on these screens
                    else -> true // Hide on other screens (e.g., "login")
                }
                val showBottomBar = when (currentRoute) {
                    "login", "checkIn", "formSente",  -> false // Show on these screens
                    else -> true // Hide on other screens (e.g., "login")
                }

                fun dismissBottomSheet() {
                    showBottomSheet = false
                }

                fun openBottomSheet() {
                    showBottomSheet = true
                }

                Scaffold(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    contentWindowInsets = contentWindowInsets,
                    floatingActionButton = {
                        if (showBottomBar) {
                            FabButton(navController, onFabClick = {
                                openBottomSheet()
                            })
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
                            .fillMaxWidth()
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
                        composable("formSente") {
                            ComoSenteScreen(navController)
                        }
                        composable("analisys"){
                            AnalisysScreen(navController)
                        }

                        composable("formSinais") {
                            Dialog(
                                onDismissRequest = {showDialog = false} ,
                                DialogProperties(
                                    usePlatformDefaultWidth = false
                                )
                            ) {
                                AnimatedVisibility(visible = true, enter = slideInVertically(), exit = slideOutVertically()) {
                                    Surface(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .background(Color.Black)
                                            .zIndex(10F),
                                    ) {
                                        SinaisDeAlertaScreen(navController)
                                    }
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
                                Surface(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(Color.Black)
                                        .zIndex(10F),
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
                                Surface(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(Color.Black)
                                        .zIndex(10F),
                                ) {
                                    FormularioAnonimoScreen(navController)
                                }
                            }
                        }

                    }
                }
                if(showBottomSheet){
                    ModalBottomSheet(
                        onDismissRequest = { showBottomSheet = false },
                        sheetState = sheetState,
                        containerColor = YouPrimaryTranslucid,
                        contentColor = Color.White,
                        modifier = Modifier
                            .padding(0.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(0.dp)
                        ) {
                            YouBottomSheet()
//                            Button(
//                                onClick = {
//                                    scope.launch { sheetState.hide() }.invokeOnCompletion {
//                                        if (!sheetState.isVisible) {
//                                            showBottomSheet = false
//                                        }
//                                    }
//                                },
//                                modifier = Modifier.align(Alignment.End)
//                            ) {
//                                Text("buttonText")
//                            }
                        }
                    }
                }
            }
        }
    }
}
