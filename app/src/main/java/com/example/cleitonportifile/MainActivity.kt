package com.example.cleitonportifile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.cleitonportifile.sample.arquitutureSkills
import com.example.cleitonportifile.sample.frameworkSkill
import com.example.cleitonportifile.sample.languageSkill
import com.example.cleitonportifile.sample.observabilitySkills
import com.example.cleitonportifile.sample.testsSkills
import com.example.cleitonportifile.screens.AnimationScreen
import com.example.cleitonportifile.screens.MainScreen
import com.example.cleitonportifile.ui.theme.CleitonPortifileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()
        setContent {
            CleitonPortifileTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                ) {
                   MainScreen()
                    AnimationScreen(stringResource(R.string.arquiteturas),arquitutureSkills)
                    AnimationScreen(stringResource(R.string.linguagens),languageSkill)
                    AnimationScreen(stringResource(R.string.framesorks),frameworkSkill)
                    AnimationScreen(stringResource(R.string.testes),testsSkills)
                    AnimationScreen(stringResource(R.string.observancia), observabilitySkills)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PagePreview() {
    CleitonPortifileTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
            ){
            MainScreen()
            AnimationScreen(stringResource(R.string.arquiteturas),arquitutureSkills)
            AnimationScreen(stringResource(R.string.linguagens),languageSkill)
            AnimationScreen(stringResource(R.string.framesorks),frameworkSkill)
            AnimationScreen(stringResource(R.string.testes),testsSkills)
            AnimationScreen(stringResource(R.string.observancia), observabilitySkills)
        }
    }
}