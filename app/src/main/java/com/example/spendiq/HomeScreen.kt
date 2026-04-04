package com.example.spendiq

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
){
    LazyColumn (
        modifier = Modifier
            .fillMaxWidth(),
        userScrollEnabled = true
    ){
        item {
            Card (){    //daily budget

            }
        }
    }
}