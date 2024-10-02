plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    //Implementacion para navegacion segura
    id("androidx.navigation.safeargs.kotlin")
    //Implementacion de parcelize
    id("kotlin-parcelize")
    // Implementacion de kapt para procesar anotaciones
    id("kotlin-kapt")
    //Implementacion para archivo de propiedades fuera de git
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")

}

android {
    namespace = "com.erick.buendia.appnoticias"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.erick.buendia.appnoticias"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }

}

dependencies {
    val retrofit2Version = "2.11.0"
    val navigationVersion = "2.7.7"
    val glideVersion = "4.16.0"
    val daggerHiltVersion = "2.52"
    val coroutinesVersion = "1.3.9"

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    //Implementation Retrofit2
    implementation("com.squareup.retrofit2:retrofit:$retrofit2Version")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit2Version")
    //Implementation Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")
    //Navigation Component
    implementation("androidx.navigation:navigation-fragment-ktx:$navigationVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navigationVersion")
    //Glide permite obtener, decodificar y mostrar imágenes fijas de video, imágenes y GIF animados.
    implementation("com.github.bumptech.glide:glide:$glideVersion")
    // Dagger Hilt Inyeccion de dependencias
    implementation("com.google.dagger:hilt-android:${daggerHiltVersion}")
    kapt("com.google.dagger:hilt-android-compiler:${daggerHiltVersion}")

    implementation("com.facebook.shimmer:shimmer:0.5.0")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}