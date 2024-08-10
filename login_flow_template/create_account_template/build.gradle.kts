import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

val moduleName = "create_account_template"

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)

    alias(libs.plugins.serialization)

    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.compose.compiler)
}


kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = moduleName
            isStatic = true
        }
    }

    jvm("desktop")

    sourceSets {
        val desktopMain by getting

        commonMain.dependencies {
            implementation(projects.dataStorage)

            implementation(projects.sonicState)
            implementation(projects.sonicUi)
            implementation(projects.sonicHelpers)

            // serialization
            implementation(libs.kotlinx.serialization.json)

            // room
            implementation(libs.androidx.room.runtime)

            // compose
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)

            // decompose
            implementation(libs.decompose)
            implementation(libs.decompose.compose)

            // decompose-essenty
            implementation(libs.essenty.lifecycle)
            implementation(libs.essenty.stateKeeper)
            implementation(libs.essenty.backHandler)
        }
    }
}

android {
    namespace = "com.ato.$moduleName"
    compileSdk = libs.versions.android.compile.sdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    defaultConfig {
        minSdk = libs.versions.android.min.sdk.get().toInt()
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                 getDefaultProguardFile("proguard-android-optimize.txt"),
                file("../proguard-rules.pro")
            )
        }
    }
}
