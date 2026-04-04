package com.example.spendiq

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNav() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "home") { //start from home

        composable("home") {
            HomeScreen(
                onAddClick = { navController.navigate("add") },
                onAnalyseClick = { navController.navigate("analyse") }
            )
        }

        composable("add") {
            AddExpenseScreen(
                onBack = { navController.popBackStack() }
            )
        }

        composable("analyse") {
            AnalyseScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}