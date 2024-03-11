package com.example.cleitonportifile.screens


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.cleitonportifile.R


@Composable
fun ProjectScreen(name: String, description: String, logo: Int) {

    var isShowSkills by remember {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { isShowSkills = !isShowSkills }
    ) {
        Image(
            painter = painterResource(id = logo),
            contentDescription = "Teste",
            modifier = Modifier.requiredSize(100.dp)
        )

        Text(text = name)

        Row(
            Modifier
                .fillMaxWidth()

        ) {
            AnimatedVisibility(visible = isShowSkills) {

                Row(
                    Modifier
                        .paddingFromBaseline(45.dp)
                        .offset(-60.dp)
                ) {
                    Text(description)
                }
            }

        }

    }


}




