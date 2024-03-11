package com.example.cleitonportifile.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cleitonportifile.R

@Preview(showBackground = true)
@Composable
fun MainScreen() {

    Column {

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.linearGradient(
                        listOf(
                            Color(0xFF3E2723),
                            Color(0xFF2196F3),
                            Color(0xFF00BFA5),
                        ),
                    )
                )
                .height(250.dp)
        ) {


            Image(
                painter = painterResource(id = R.drawable.foto_perfil),
                contentDescription = stringResource(id = R.string.user_name),
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .align(Alignment.Center)
            )

        }

        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
            ) {

                Text(
                    text = stringResource(id = R.string.user_name),
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Justify,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                carrierDescription()

            }


        }

    }

}


@Composable
fun carrierDescription() {

    Column {

        Row { formatDescription(R.string.target)}

        Row { formatTitle(R.string.text_1_title) }
        Row { formatDescription(R.string.text_1) }

        Row { formatTitle(R.string.text_2_title) }
        Row { formatDescription(R.string.text_2) }

        Row { formatTitle(R.string.text_3_title) }
        Row { formatDescription(R.string.text_3) }

    }

}

@Composable
fun formatTitle(subtitle: Int) {

    Text(
        text = stringResource(id = subtitle),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        textAlign = TextAlign.Justify,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold

    )

}

@Composable
fun formatDescription(description: Int) {

    Text(
        text = stringResource(id = description),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        textAlign = TextAlign.Justify,
        fontSize = 18.sp,
        fontWeight = FontWeight.Light

    )

}