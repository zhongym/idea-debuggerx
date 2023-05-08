@file:Suppress("ConvertLambdaToReference")

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  java
  id("org.jetbrains.intellij") version "1.13.2"
  kotlin("jvm") version "1.8.10"
}

group = "com.github.lppedd"
version = "0.1"

repositories {
  mavenCentral()
}


dependencies {
  compileOnly(kotlin("stdlib"))
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

intellij {
  version.set("IU-231.8770.65")
  downloadSources.set(true)
  plugins.set(listOf("java"))
}

configure<JavaPluginConvention> {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8
}

tasks {
  test {
    useJUnitPlatform()
  }

  val kotlinSettings: KotlinCompile.() -> Unit = {
    kotlinOptions.apiVersion = "1.3"
    kotlinOptions.jvmTarget = "1.8"
    kotlinOptions.freeCompilerArgs += listOf(
      "-Xno-call-assertions",
      "-Xno-receiver-assertions",
      "-Xno-param-assertions",
      "-Xjvm-default=all"
    )
  }

  compileKotlin(kotlinSettings)
  compileTestKotlin(kotlinSettings)

  patchPluginXml {
    version.set(project.version.toString())
    sinceBuild.set("201.6668")
    untilBuild.set("")

    val projectPath = projectDir.path
    pluginDescription.set((File("$projectPath/plugin-description.html").readText(Charsets.UTF_8)))
  }
}
