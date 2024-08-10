import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

val moduleName = "data_storage_template"

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)

    alias(libs.plugins.serialization)

    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.compose.compiler)

    alias(libs.plugins.ksp)
    alias(libs.plugins.room)
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

    sourceSets.all {
        languageSettings.optIn("kotlin.experimental.ExperimentalObjCName")
    }

    jvm("desktop")

    sourceSets.commonMain {
        kotlin.srcDir("build/generated/ksp/metadata")
    }

    sourceSets {
        val desktopMain by getting

        desktopMain.dependencies {
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.sqlite.bundled)
        }

        commonMain.dependencies {
            implementation(projects.sonicState)

            implementation(libs.kotlinx.serialization.json)
            implementation(libs.androidx.room.runtime)

            // compose
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)

            // firebase
            implementation(libs.kmp.firebase.database)
            implementation(libs.kmp.firebase.firestore)
            implementation(libs.kmp.firebase.auth)

            // date
            implementation(libs.kotlinx.datetime)

            // Google/Apple auth
            implementation(libs.kmpauth.google) //Google One Tap Sign-In
            implementation(libs.kmpauth.firebase) //Integrated Authentications with Firebase
            implementation(libs.kmpauth.uihelper) //UiHelper SignIn buttons (AppleSignIn, GoogleSignInButton)

        }
        androidMain.dependencies {

        }
        nativeMain.dependencies {
            implementation(libs.sqlite.bundled)
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

dependencies {
    implementation(libs.androidx.sqlite.bundled.jvm)
    add("kspCommonMainMetadata", libs.androidx.room.compiler)
}

tasks.withType<org.jetbrains.kotlin.gradle.dsl.KotlinCompile<*>>().configureEach {
    if (name != "kspCommonMainKotlinMetadata") {
        dependsOn("kspCommonMainKotlinMetadata")
    }
}

room {
    schemaDirectory("$projectDir/schemas")
}

