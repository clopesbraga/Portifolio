package com.example.cleitonportifile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.cleitonportifile.sample.arquitutureSkills
import com.example.cleitonportifile.sample.bottonOptionsBar
import com.example.cleitonportifile.sample.frameworkSkill
import com.example.cleitonportifile.sample.languageSkill
import com.example.cleitonportifile.sample.observabilitySkills
import com.example.cleitonportifile.sample.testsSkills
import com.example.cleitonportifile.screens.AnimationScreen
import com.example.cleitonportifile.screens.MainScreen
import com.example.cleitonportifile.screens.ProjectScreen
import com.example.cleitonportifile.ui.theme.CleitonPortifileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()
        setContent {
            val navController = rememberNavController()
            CleitonPortifileTheme {
                Scaffold(bottomBar = {
                    inputButtonBar(navController)
                })
                { innerpading ->

                    NavHost(navController = navController, startDestination = "Experiencias") {

                        composable(route = "Experiencias") {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .verticalScroll(rememberScrollState())
                                    .padding(innerpading)
                            ) {

                                MainScreen()
                            }
                        }
                        composable(route = "Habilitades") {
                            Column(
                                Modifier
                                    .fillMaxSize()
                                    .verticalScroll(rememberScrollState())

                            ) {
                                Text(
                                    text = "Minha Habilidades",
                                    Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp),
                                    textAlign = TextAlign.Left,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                AnimationScreen(stringResource(R.string.arquiteturas), arquitutureSkills)
                                AnimationScreen(stringResource(R.string.linguagens), languageSkill)
                                AnimationScreen(stringResource(R.string.framesorks), frameworkSkill)
                                AnimationScreen(stringResource(R.string.testes), testsSkills)
                                AnimationScreen(stringResource(R.string.observancia), observabilitySkills)
                            }
                        }
                        composable(route = "Projetos") {

                            Column(
                                Modifier
                                    .fillMaxSize()
                                    .paddingFromBaseline(100.dp)
                            ) {
                                ProjectScreen(
                                    stringResource(id= R.string.afim_de_feira),
                                    stringResource(id = R.string.descAfimDeFeira),
                                    R.drawable.ic_logo_afimdefeira
                                )

                                ProjectScreen(
                                    stringResource(id= R.string.github),
                                    stringResource(id = R.string.descGitHub),
                                    R.drawable.ic_logo_githubrepo
                                )

                                ProjectScreen(
                                    stringResource(id= R.string.portifile),
                                    stringResource(id = R.string.descPortifile),
                                    R.drawable.jetpackicon
                                )
                            }

                        }

                    }

                }

            }
        }
    }
}

@Composable
fun inputButtonBar(navController: NavController) {
    BottomAppBar {
        val actions = @Composable {

            var selectedItem by remember {
                mutableStateOf(bottonOptionsBar.first())
            }
            bottonOptionsBar.forEach { item ->
                val text = item.name
                val icon = item.icons
                NavigationBarItem(
                    selected = selectedItem == item,
                    onClick = {
                        selectedItem = item
                        val route = when (text) {
                            "Experiencias" -> "Experiencias"
                            "Habilitades" -> "Habilitades"

                            else -> {
                                "Projetos"
                            }
                        }
                        navController.navigate(route, navOptions = navOptions {
                            launchSingleTop = true
                            popUpTo(navController.graph.startDestinationId)
                        })
                    },
                    icon = { Icon(imageVector = icon, contentDescription = null) },
                    label = { Text(text = text) },
                )

            }

        }
        actions()
    }

}