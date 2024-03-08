package com.example.cleitonportifile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.input.KeyboardType.Companion.Text

import androidx.compose.ui.tooling.preview.Preview

import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.cleitonportifile.sample.arquitutureSkills
import com.example.cleitonportifile.sample.bottonOptionsBar
import com.example.cleitonportifile.sample.frameworkSkill
import com.example.cleitonportifile.sample.languageSkill
import com.example.cleitonportifile.sample.observabilitySkills
import com.example.cleitonportifile.sample.testsSkills
import com.example.cleitonportifile.screens.AnimationScreen
import com.example.cleitonportifile.screens.MainScreen
import com.example.cleitonportifile.ui.theme.CleitonPortifileTheme
import kotlinx.coroutines.selects.select

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()
        setContent {
            CleitonPortifileTheme {
                Scaffold(
                    bottomBar = {
                        inputButtonBar()
                    }
                ) { innerpading ->

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .padding(innerpading)
                    ) {
                        MainScreen()
                        AnimationScreen(stringResource(R.string.arquiteturas), arquitutureSkills)
                        AnimationScreen(stringResource(R.string.linguagens), languageSkill)
                        AnimationScreen(stringResource(R.string.framesorks), frameworkSkill)
                        AnimationScreen(stringResource(R.string.testes), testsSkills)
                        AnimationScreen(stringResource(R.string.observancia), observabilitySkills)
                    }

                }


            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PagePreview() {
    CleitonPortifileTheme {

        Scaffold(bottomBar = {
            inputButtonBar()
        })
        { innerpading ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(innerpading)
            ) {
                MainScreen()
            }
        }
    }

}


@Composable
fun inputButtonBar() {
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
                    onClick = { selectedItem = item },
                    icon = { Icon(imageVector = icon, contentDescription = null) },
                    label = { Text(text = text) },
                )

            }

        }
        actions()
    }

}