plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.nemo.proyectoguiatributariapsm400"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.nemo.proyectoguiatributariapsm400"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}
dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.glide) //libreria para gif
    implementation(libs.gifDrawable)
    implementation(libs.typewriter)
    implementation(libs.androidx.work)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}