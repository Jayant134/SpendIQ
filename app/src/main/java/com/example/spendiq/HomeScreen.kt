package com.example.spendiq

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.spendiq.ui.theme.DisplayXLargeBold
import com.example.spendiq.ui.theme.StatusBarFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onAddClick: () -> Unit,
    onAnalyseClick: () -> Unit,
    totalAmount: Int,
    lastCategory: String,
    modifier: Modifier = Modifier
){
    Scaffold(
//        modifier = Modifier
//            .clip(shape = RoundedCornerShape(Start = 24.dp, topEnd = 24.dp))
//            .background(Color(0xFFF0F5F8)),
        containerColor = Color(0xFFF0F5F8),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = stringResource(R.string.app_name), style = StatusBarFont)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFF0F5F8)
                ),


            )
        },
        content = {paddingValues ->
            val extraTopPadding = dimensionResource(R.dimen.padding_large)
            HomeScreenUi(
                totalAmount = totalAmount,
                lastCategory = lastCategory,
                paddingValues = PaddingValues(top = paddingValues.calculateTopPadding()+extraTopPadding)
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
//                    .background(Color.White),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Button(
                    onClick = onAddClick
                ) {
                    Row() {
                        Image(painter = painterResource(R.drawable.add), contentDescription = null, modifier = Modifier.size(20.dp))
                        Text(text = stringResource(R.string.addExpense), style = MaterialTheme.typography.bodyMedium)
                    }
                }

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = onAnalyseClick
                ) {
                    Row() {
                        Image(painter = painterResource(R.drawable.analysis), contentDescription = null, modifier = Modifier.size(20.dp))
                        Text(text = stringResource(R.string.analyse), style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    )
}

@Composable
fun HomeScreenUi(
    modifier: Modifier = Modifier,
    totalAmount: Int,
    lastCategory: String,
    paddingValues: PaddingValues
){
    Box(
        modifier = Modifier
            .padding(top = paddingValues.calculateTopPadding(), start = 16.dp, end = 16.dp) //care for start and end
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
//                .padding(all = dimensionResource(R.dimen.padding_large)),
            userScrollEnabled = true
        ) {
            item {
                Card(      //daily budget
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .height(dimensionResource(R.dimen.otherCardHeight))
                        .fillMaxWidth(),
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
                        var expenseToday by remember { mutableStateOf("") }
                        val randomAmount = remember { (50..300).random() }
                        expenseToday = randomAmount.toString()
                        Text(
                            text = stringResource(R.string.dailyExpense),
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = totalAmount.toString(),
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
                            text = stringResource(R.string.aiInsight),
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = if (lastCategory.isNotEmpty())
                                "High spending in $lastCategory"
                            else
                                "No data yet",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }//item-1 end

            //item-2: Image Cards
            item{
                Spacer(modifier = Modifier.height(16.dp))

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
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(
        onAddClick = {},
        onAnalyseClick = {},
        0,
        lastCategory = ""
    )
}