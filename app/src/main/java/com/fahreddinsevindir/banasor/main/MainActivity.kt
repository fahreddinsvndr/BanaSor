package com.fahreddinsevindir.banasor.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.fahreddinsevindir.banasor.navigation.NavGraph
import com.fahreddinsevindir.banasor.navigation.Screen
import com.fahreddinsevindir.banasor.ui.theme.BanaSorTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BanaSorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),

                    ) {

                    val navController = rememberNavController()

                    val navBackStackEntry by navController.currentBackStackEntryAsState()

                    when (navBackStackEntry?.destination?.route) {
                        Screen.Splash.route -> false
                        else -> true
                    }

                    Scaffold {
                        NavGraph(navController = navController, it)
                    }

                }
            }
        }
    }
}

