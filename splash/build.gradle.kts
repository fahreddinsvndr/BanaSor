import com.fahreddinsevindir.buildsrc.Deps

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.fahreddinsevindir.splash"
    compileSdk = com.fahreddinsevindir.buildsrc.Configuration.compileSdk

    defaultConfig {
        minSdk = com.fahreddinsevindir.buildsrc.Configuration.minSdk

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
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

    with(Deps.Junit){
        testImplementation(junit4)
        androidTestImplementation(test)
        androidTestImplementation(espresso)
        androidTestImplementation(ui)
    }


}