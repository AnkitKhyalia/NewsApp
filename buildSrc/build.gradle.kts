import org.gradle.kotlin.dsl.`kotlin-dsl`
//import org.jetbrains.kotlin.gradle.internal.kapt.incremental.UnknownSnapshot.classpath

plugins {
//    id("org.gradle.kotlin.kotlin-dsl") version "1.7.0"
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
}
//dependencies {
//    classpath 'com.google.dagger:hilt-android-gradle-plugin:2.44'
//}