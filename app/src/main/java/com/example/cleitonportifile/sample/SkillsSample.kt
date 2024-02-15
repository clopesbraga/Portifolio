package com.example.cleitonportifile.sample

import com.example.cleitonportifile.model.SkillsModel
import kotlin.random.Random

val languageSkill = listOf(
        SkillsModel(name ="Kotlin",level = Random.nextFloat()),
        SkillsModel(name ="Java",level = Random.nextFloat()),
        SkillsModel(name ="Git",level = Random.nextFloat())
    )

val frameworkSkill = listOf(
    SkillsModel(name ="Retrofit",level = Random.nextFloat()),
    SkillsModel(name ="Room",level = Random.nextFloat()),
    SkillsModel(name ="RXJava",level = Random.nextFloat()),
    SkillsModel(name ="Coroutines",level = Random.nextFloat()),
    SkillsModel(name ="JetPackCompose",level = Random.nextFloat())
)

val arquitutureSkills = listOf(
    SkillsModel(name ="MVC",level = Random.nextFloat()),
    SkillsModel(name ="MVVM",level = Random.nextFloat()),
)

val testsSkills = listOf(
    SkillsModel(name ="JUnit",level = Random.nextFloat()),
    SkillsModel(name ="Mockito",level = Random.nextFloat()),
)

val observabilitySkills = listOf(
    SkillsModel(name ="Google Analytics",level = Random.nextFloat()),
    SkillsModel(name ="Crashlytics",level = Random.nextFloat()),
)