import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")

}
kapt {
    useBuildCache = false
    arguments {
        arg("kapt.log.processor.args", "true")
    }
}

android {
    namespace = "com.example.newsapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.newsapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {


    implementation(Dependencies.coreKtx)
    implementation(Dependencies.material)
    implementation(Dependencies.appcompat)
    implementation(Dependencies.lifecycleViewModelKtx)
    implementation(Dependencies.lifecycleRuntimektx)
    implementation(Dependencies.activityCompose)
    implementation(Dependencies.composeBom)
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeUiGraphics)
    implementation(Dependencies.composeUiToolingPreview)
    implementation(Dependencies.composeMaterial3)
   implementation(project(Modules.utilities))

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

//    implementation( "com.google.dagger:dagger:2.44.2")
//    kapt ("com.google.dagger:dagger-compiler:2.44.2")
    implementation("androidx.navigation:navigation-compose:2.7.4")
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.48")
//    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    kapt("androidx.hilt:hilt-compiler:1.0.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

//    implementation(Dependencies.retrofit)
//    implementation(Dependencies.okhttp)
//    implementation(Dependencies.gsonConverter)
//    implementation(Dependencies.moshi)
//    implementation(Dependencies.moshiConverter)
//    implementation(Dependencies.loggingInterceptor)



    implementation( "com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
   implementation("com.squareup.moshi:moshi-kotlin:1.13.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.8.1")

//    implementation(Dependencies.hiltAndroid)
//    kapt(Dependencies.hiltCompiler)
//    kapt(Dependencies.hiltAndroidCompiler)
//    implementation(Dependencies.hiltNavigatonComose)
//    implementation( "com.google.dagger:hilt-android:2.39.1")
//
//    kapt ("com.google.dagger:hilt-compiler:2.39.1")
    implementation(Dependencies.coroutinesCore)
    implementation(Dependencies.coroutinesAndroid)
    implementation("androidx.core:core-splashscreen:1.0.1")
    implementation("io.coil-kt:coil-compose:2.2.0")
}
kapt{
    correctErrorTypes = true
}