package com.example.cleitonportifile.sample

import com.example.cleitonportifile.model.SkillsModel


private var BIGGER : Float = 0.3f
private var MEDIUM : Float = 0.5f
private var HIGH : Float = 0.9f

val languageSkill = listOf(
        SkillsModel(name ="Kotlin",level = HIGH),
        SkillsModel(name ="Java",level = HIGH),
        SkillsModel(name ="Git",level = HIGH)
    )

val frameworkSkill = listOf(
    SkillsModel(name ="Retrofit",level = HIGH),
    SkillsModel(name ="Room",level =  HIGH),
    SkillsModel(name ="RXJava",level =  MEDIUM),
    SkillsModel(name ="Coroutines",level =  MEDIUM),
    SkillsModel(name ="JetPackCompose",level =  BIGGER)
)

val arquitutureSkills = listOf(
    SkillsModel(name ="MVC",level =  HIGH),
    SkillsModel(name ="MVVM",level = HIGH),
)

val testsSkills = listOf(
    SkillsModel(name ="JUnit",level = MEDIUM),
    SkillsModel(name ="Mockito",level = MEDIUM),
)

val observabilitySkills = listOf(
    SkillsModel(name ="Google Analytics",level = MEDIUM),
    SkillsModel(name ="Crashlytics",level = MEDIUM)
)