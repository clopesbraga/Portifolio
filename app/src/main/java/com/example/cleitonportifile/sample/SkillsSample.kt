package com.example.cleitonportifile.sample

import com.example.cleitonportifile.model.SkillsModel
import kotlin.random.Random

val languageSkill = listOf(
        SkillsModel(name ="Kotlin",level = Random.nextFloat()),
        SkillsModel(name ="Android",level = Random.nextFloat()),
        SkillsModel(name ="Git",level = Random.nextFloat())
    )

val frameworkSkill = listOf(
    SkillsModel(name ="Retrofit",level = Random.nextFloat()),
    SkillsModel(name ="Room",level = Random.nextFloat()),
    SkillsModel(name ="RXJava",level = Random.nextFloat()),
    SkillsModel(name ="JetPackCompose",level = Random.nextFloat())

)

val arquitutureSkills = listOf(

    SkillsModel(name ="MVC",level = Random.nextFloat()),
    SkillsModel(name ="MVVM",level = Random.nextFloat()),

)