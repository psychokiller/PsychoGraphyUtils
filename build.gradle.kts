plugins {
    application
    kotlin("jvm") version "1.3.50"
}

application {
    mainClassName = "ahmyouss.PsychoGraphyProjectCreatorKt"
}

dependencies {
    implementation("com.github.ajalt:clikt:2.2.0")
    implementation(kotlin("stdlib"))
}

repositories {
    mavenCentral()
}
