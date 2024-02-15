package com.example.cleitonportifile.screens

import android.graphics.drawable.Icon
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cleitonportifile.R
import com.example.cleitonportifile.model.SkillsModel
import kotlinx.coroutines.delay

@Composable
fun AnimationScreen(
    nameskill: String,
    skills: List<SkillsModel> =listOf()
){
    Column {
        sKillLine(nameskill,skills)
    }
}

@Composable
fun sKillLine(lineName : String,skills: List<SkillsModel>){

    var isShowSkills by remember {
        mutableStateOf(false)
    }
    Row(
        Modifier
            .padding(8.dp)
            .clip(CircleShape)
            .padding(8.dp)
            .clickable {
                isShowSkills = !isShowSkills
            },
    ){

        Text(
            text = lineName,Modifier, fontSize = 18.sp
        )
        Icon(
            imageVector = Icons.Filled.KeyboardArrowRight,
            contentDescription = "seta de habilidades"
        )
    }
    skillsLineAnimation(skills,isShowSkills)
}

@Composable
fun skillsLineAnimation(skills: List<SkillsModel>,isShowSkills : Boolean){

    AnimatedVisibility(visible = isShowSkills) {

        Column{
            for(skill in skills){
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)

                ){

                    var level by remember {
                        mutableStateOf(0f)
                    }
                    LaunchedEffect(null) {
                        delay(0)
                        level = skill.level
                    }
                    val animatedCircularValue by animateFloatAsState(
                        targetValue = level,
                        label = stringResource(id = R.string.circular_shape),
                        animationSpec = keyframes {
                            this.durationMillis = 500
                        }
                    )
                    CircularProgressIndicator(
                        animatedCircularValue,
                    )
                    Text(text = skill.name)

                }

            }
        }

    }

}

