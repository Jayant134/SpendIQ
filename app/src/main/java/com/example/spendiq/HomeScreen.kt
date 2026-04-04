package com.example.spendiq

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(

    modifier: Modifier = Modifier
){
    LazyColumn (
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.padding_medium)),
        userScrollEnabled = true
    ){
        item {
            Card (      //daily budget
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small)),
                elevation = CardDefaults.cardElevation(2.dp)
            ){
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = stringResource(R.string.daily_budget),
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        text = stringResource(R.string.val_daily_budget),
                        style = MaterialTheme.typography.titleSmall
                    )
                }
            }

            Card (  //daily expense
                modifier = Modifier.fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small)),
                elevation = CardDefaults.cardElevation(2.dp)
            ){
                Row (){
                    Text(
                        text = stringResource(R.string.dailyExpense)
                    )
                    Text(
                        text = stringResource(R.string.valDailyExpense)
                    )
                }
            }

            Card (  //monthly expense
                modifier = Modifier.fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small)),
                elevation = CardDefaults.cardElevation(2.dp)
            ){
                Row (){
                    Text(
                        text = stringResource(R.string.monthlyExpense)
                    )
                    Text(
                        text = stringResource(R.string.valMonthlyExpense)
                    )
                }
            }

            Column (
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Text(
                    text = stringResource(R.string.aiInsight)
                )
                Text(
                    text = stringResource(R.string.food)
                )
                Text(
                    text = stringResource(R.string.travel)
                )
            }



        }
    }

    Row(
        modifier = Modifier.fillMaxWidth()
    ){
        Button(
            onClick = {  }
        ) {
            Row(){
                Image(painter = painterResource(R.drawable.add), contentDescription = null)
                Text(text = stringResource(R.string.addExpense))
            }
        }

        Spacer(modifier = Modifier.width(8.dp))
        Button(
            onClick = { }
        ) {
            Row(){
                Image(painter = painterResource(R.drawable.analysis), contentDescription = null)
                Text(text = stringResource(R.string.analyse))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}