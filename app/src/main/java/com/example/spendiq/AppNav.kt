package com.example.spendiq

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNav() {
    val navController = rememberNavController()

    var totalAmount by remember { mutableStateOf(0) } // 🔥 shared

    NavHost(navController, startDestination = "home") {

        composable("home") {
            HomeScreen(
                totalAmount = totalAmount,
                onAddClick = { navController.navigate("add") },
                onAnalyseClick = { navController.navigate("analyse") }
            )
        }

        composable("add") {
            AddExpenseScreen(
                onBack = { navController.popBackStack() },
                onAddAmount = { value ->
                    totalAmount += value   // 🔥 update here
                }
            )
        }

        composable("analyse") {
            AnalyseScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}