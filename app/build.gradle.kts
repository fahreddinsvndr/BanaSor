import com.fahreddinsevindir.buildsrc.Deps

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    namespace = "com.fahreddinsevindir.banasor"
    compileSdk = com.fahreddinsevindir.buildsrc.Configuration.compileSdk

    defaultConfig {
        applicationId = com.fahreddinsevindir.buildsrc.Configuration.applicationId
        minSdk = com.fahreddinsevindir.buildsrc.Configuration.minSdk
        targetSdk = com.fahreddinsevindir.buildsrc.Configuration.targetSdk
        versionCode = com.fahreddinsevindir.buildsrc.Configuration.versionCode
        versionName = com.fahreddinsevindir.buildsrc.Configuration.versionName

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

    implementation(project(":splash"))
    implementation(project(":onboarding"))

    implementation(Deps.AndroidX.Core.coreKtx)

    implementation(Deps.AndroidX.Lifecycle.runtime)

    implementation(Deps.AndroidX.Activity.compose)

    implementation(Deps.AndroidX.Navigation.compose)

    with(Deps.AndroidX.Lifecycle) {
        implementation(viewModelKtx)
        implementation(runtimeKtx)
        implementation(viewModelCompose)
        implementation(runtime)
    }

    with(Deps.Google.DaggerHilt) {
        implementation(android)
        implementation(navigationCompose)
        kapt(compiler)
    }

    with(Deps.Org.Jetbrains.Kotlinx) {
        implementation(coroutineCore)
        implementation(coroutineAndroid)
    }

    with(Deps.AndroidX.Compose) {
        implementation(platform(boom))
        implementation(ui)
        implementation(graphics)
        implementation(toolingPreview)
        implementation(material3)
        debugImplementation(toolingPreview)
        debugImplementation(uiTest)
        androidTestImplementation(platform(boom))
    }

    with(Deps.Junit) {
        testImplementation(junit4)
        androidTestImplementation(test)
        androidTestImplementation(espresso)
        androidTestImplementation(ui)
    }


}