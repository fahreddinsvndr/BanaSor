package com.fahreddinsevindir.buildsrc

object Deps {

    object AndroidX {

        object Core {
            const val coreKtx = "androidx.core:core-ktx:${Version.androidx_core}"
        }

        object Compose {
            const val ui = "androidx.compose.ui:ui"
            const val toolingPreview =
                "androidx.compose.ui:ui-tooling-preview"
            const val boom = "androidx.compose:compose-bom:${Version.boom_version}"
            const val graphics = "androidx.compose.ui:ui-graphics"
            const val material3 = "androidx.compose.material3:material3"
            const val uiTest = "androidx.compose.ui:ui-test-manifest"
        }

        object Lifecycle {
            const val runtime =
                "androidx.lifecycle:lifecycle-runtime-ktx:${Version.androidx_lifecycle}"
        }

        object Activity {
            const val compose = "androidx.activity:activity-compose:${Version.activity_compose}"
        }

        object AppCompat {
            const val appCompat = "androidx.appcompat:appcompat:${Version.app_compat}"
        }

        object Navigation {
            const val compose = "androidx.navigation:navigation-compose:${Version.navigation_version}"
        }

    }

    object Google {

        object Android {
            const val material = "com.google.android.material:material:${Version.android_material}"
        }
    }


    object Junit {
        const val junit4 = "junit:junit:${Version.junit_version}"
        const val test = "androidx.test.ext:junit:${Version.junit_test}"
        const val espresso = "androidx.test.espresso:espresso-core:${Version.junit_test}"
        const val ui = "androidx.compose.ui:ui-test-junit4"
    }


    object AirBnb {

        const val lottie = "com.airbnb.android:lottie-compose:${Version.lottie_version}"

    }
}


