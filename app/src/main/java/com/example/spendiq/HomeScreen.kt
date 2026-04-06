package com.example.spendiq

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.spendiq.ui.theme.DisplayXLargeBold

@Composable
fun HomeScreen(
    onAddClick: () -> Unit,
    onAnalyseClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Box(

    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = dimensionResource(R.dimen.padding_large)),
            userScrollEnabled = true,
        ) {
            item {
                Card(      //daily budget
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .height(dimensionResource(R.dimen.otherCardHeight))
                        .fillMaxWidth(),
 //                       .padding(start = dimensionResource(R.dimen.padding_large), end = dimensionResource(R.dimen.padding_large)),
                    elevation = CardDefaults.cardElevation(3.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(dimensionResource(R.dimen.padding_medium)),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = stringResource(R.string.daily_budget),
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = stringResource(R.string.val_daily_budget),
                            style = MaterialTheme.typography.titleSmall
                        )
                    }
                }

                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacerCardHeight)))

                Card(  //daily expense
                    shape = MaterialTheme.shapes.medium,    //for rounded corner
                    modifier = Modifier
                        .height(dimensionResource(R.dimen.bigCardHeight))
                        .fillMaxWidth(),
//                        .padding(start = dimensionResource(R.dimen.padding_large), end = dimensionResource(R.dimen.padding_large)),
                    elevation = CardDefaults.cardElevation(3.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(dimensionResource(R.dimen.padding_medium)),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = stringResource(R.string.dailyExpense),
                            style = MaterialTheme.typography.displayLarge
                        )
                        Text(
                            text = stringResource(R.string.valDailyExpense),
                            style = DisplayXLargeBold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacerCardHeight)))

                Card(  //monthly expense
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .height(dimensionResource(R.dimen.otherCardHeight))
                        .fillMaxWidth(),
//                        .padding(start = dimensionResource(R.dimen.padding_large), end = dimensionResource(R.dimen.padding_large)),
                    elevation = CardDefaults.cardElevation(3.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(dimensionResource(R.dimen.padding_large)),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = stringResource(R.string.monthlyExpense),
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = stringResource(R.string.valMonthlyExpense),
                            style = MaterialTheme.typography.titleSmall
                        )
                    }
                }

                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacerCardHeight)))

                Card(  //AI insight
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .fillMaxWidth(),
//                        .padding(start = dimensionResource(R.dimen.padding_large), end = dimensionResource(R.dimen.padding_large)),
                    elevation = CardDefaults.cardElevation(3.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(dimensionResource(R.dimen.padding_large)),
                        verticalArrangement = Arrangement.Center
                    ) {
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
            }//item-1 end

            //item-2: Image Cards
            item{
                Text(
                    text = "Analysis",
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(top =8.dp, bottom = 8.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f),
                        elevation = CardDefaults.cardElevation(3.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.piechart),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f),
                        elevation = CardDefaults.cardElevation(3.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.recommededchart),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
        //buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(dimensionResource(R.dimen.padding_medium)),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = onAddClick
            ) {
                Row() {
                    Image(painter = painterResource(R.drawable.add), contentDescription = null)
                    Text(text = stringResource(R.string.addExpense))
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = onAnalyseClick
            ) {
                Row() {
                    Image(painter = painterResource(R.drawable.analysis), contentDescription = null)
                    Text(text = stringResource(R.string.analyse))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(
        onAddClick = {},
        onAnalyseClick = {}
    )
}