import com.fahreddinsevindir.buildsrc.Deps

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")

}

android {
    namespace = "com.fahreddinsevindir.onboarding"
    compileSdk = 33

    defaultConfig {
        minSdk = 23

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    implementation(Deps.AndroidX.Core.coreKtx)

    implementation(Deps.AndroidX.AppCompat.appCompat)

    implementation(Deps.Google.Android.material)


    implementation(Deps.AirBnb.lottie)


    implementation(Deps.AndroidX.Lifecycle.runtime)

    implementation(Deps.AndroidX.Activity.compose)

    implementation(Deps.Google.Accompanist.pager)

    implementation(Deps.Google.Accompanist.pager_indicator)

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