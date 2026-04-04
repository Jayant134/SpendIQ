package com.example.spendiq

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun AnalyseScreen(onBack: () -> Unit) {
    Button(onClick = onBack) {
        Text("Back")
    }
}