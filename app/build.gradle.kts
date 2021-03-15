import java.io.FileInputStream
import java.util.*

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

val apiProperties = Properties()
apiProperties.load(FileInputStream(rootProject.file("api.properties")))

android {
    compileSdkVersion(AppConfig.compileSdk)
    buildToolsVersion(AppConfig.buildToolsVersion)

    defaultConfig {
        applicationId = AppConfig.applicationName

        minSdkVersion(AppConfig.minSdk)
        targetSdkVersion(AppConfig.targetSdk)

        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation


        buildConfigField("String", "BASE_URL", "\"${apiProperties.getProperty("BASE_URL")}\"")
    }

    buildTypes {
        getByName(AppConfig.release) {
            isMinifyEnabled = true
            proguardFile(AppConfig.proguardConsumerRules)
        }
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8

        kotlinOptions {
            jvmTarget = AppConfig.javaVersion
        }
    }
}


dependencies {
    kapt(Dependencies.daggerKapt)

    // App libs
    implementation(arrayListOf<String>().apply {
        addAll(Dependencies.kotlinBundle)
        addAll(Dependencies.androidBundle)
        addAll(Dependencies.lifecycleBundle)
        addAll(Dependencies.threadingBundle)
        addAll(Dependencies.databaseBundle)
        addAll(Dependencies.networkingBundle)
        addAll(Dependencies.daggerBundle)
    })

    // Test libs
    testImplementation(Dependencies.testLibraries)
}