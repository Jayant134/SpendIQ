package com.example.spendiq

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddExpenseScreen(
        onBack: () -> Unit,
        onAddAmount: (Int) -> Unit,
        onCategorySelected: (String) -> Unit
    ) {
    var amount by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_large))
    ){
        Column(){
            //amount input field
            Text(text = stringResource(R.string.addAmount), style = MaterialTheme.typography.titleSmall,modifier = Modifier.padding(8.dp))

            TextField(
                value = amount,
                onValueChange = {amount = it},
                singleLine = true,
                label = {Text("Amount")},
                modifier = Modifier
                    .fillMaxWidth(),
                shape = MaterialTheme.shapes.medium
            )

            Spacer(Modifier.height(16.dp))

            Text(text = stringResource(R.string.selectCategory), style = MaterialTheme.typography.titleSmall, modifier = Modifier.padding(8.dp))
            //dropdown menu
            var expanded by remember { mutableStateOf(false) }
            var selected by remember { mutableStateOf("Select Category") }
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded },

            ) {
                TextField(
                    value = selected,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Category") },
                    modifier = Modifier.menuAnchor(),
                    shape = MaterialTheme.shapes.medium
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {

                    listOf("Food", "Travel", "Shopping").forEach { item ->
                        DropdownMenuItem(
                            text = { Text(item) },
                            onClick = {
                                selected = item
                                expanded = false
                                onCategorySelected(item)   // 🔥 send category up
                            }
                        )
                    }
                }
            }

            Spacer(Modifier.height(16.dp))

            Text(text = stringResource(R.string.note), style = MaterialTheme.typography.titleSmall, modifier = Modifier.padding(8.dp))
            var note by remember { mutableStateOf("") }
            TextField(
                value = note,
                onValueChange = {note = it},
                singleLine = true,
                label = {Text("Note")},
                modifier = Modifier
                    .fillMaxWidth(),
                shape = MaterialTheme.shapes.medium
            )

            Spacer(Modifier.height(16.dp))

            //row of two buttons
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Button(
                    onClick = {
                        val finalAmount = amount.toIntOrNull() ?: 0
                        onAddAmount(finalAmount)   // 🔥 send data back
                        onBack()
                    }
                ) {
                    Row() {
                        Image(painter = painterResource(R.drawable.add), contentDescription = null, modifier = Modifier.size(20.dp))
                        Text(text = "Add")
                    }
                }

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = onBack,
                ) {
                    Text("Back")
                }
            }
        }
    }
}