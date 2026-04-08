package com.example.spendiq

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun AnalyseScreen(onBack: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F5F8))
            .padding(dimensionResource(R.dimen.padding_large))
    ){
        Column(){

            //upload bill
            Text(text = "Upload bill image", style = MaterialTheme.typography.titleSmall,modifier = Modifier.padding(top = 8.dp, bottom = 8.dp))
            var imageUri by remember { mutableStateOf<Uri?>(null) }
            var amountFromBill by remember {mutableStateOf("")} //to generate a random bill
            val launcher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.GetContent()
            ) { uri ->
                imageUri = uri
                val randomAmount = (100..1000).random()
                amountFromBill = randomAmount.toString()
            }
            Box(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .height(150.dp)
                    .border(1.dp, Color.Gray, RoundedCornerShape(12.dp))
                    .clickable { launcher.launch("image/*") },
                contentAlignment = Alignment.Center
            ) {
                if (imageUri == null) {
                    Text("Upload Image")
                } else {
                    Image(
                        painter = rememberAsyncImagePainter(imageUri),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            Spacer(Modifier.height(16.dp))

            //amount from bill
            Text(text = "Amount", style = MaterialTheme.typography.titleSmall,modifier = Modifier.padding(top = 8.dp, bottom = 8.dp))
            TextField(
                value = amountFromBill,
                onValueChange = {amountFromBill = it},
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth(),
                shape = MaterialTheme.shapes.medium
            )

            Spacer(Modifier.height(16.dp))

            //bill history
            Text(text = "Bill history", style = MaterialTheme.typography.titleSmall,modifier = Modifier.padding(top = 8.dp, bottom = 8.dp))
            LazyRow (
                userScrollEnabled = true,
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.height(120.dp)
            ){
                item{
                    Card(
                        modifier = Modifier
//                        .weight(1f)
                            .aspectRatio(1f),
                        elevation = CardDefaults.cardElevation(3.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.bill1),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
                item{
                    Card(
                        modifier = Modifier
//                        .weight(1f)
                            .aspectRatio(1f),
                        elevation = CardDefaults.cardElevation(3.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.bill2),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
                item{
                    Card(
                        modifier = Modifier
//                        .weight(1f)
                            .aspectRatio(1f),
                        elevation = CardDefaults.cardElevation(3.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.bill3),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
                item{
                    Card(
                        modifier = Modifier
//                        .weight(1f)
                            .aspectRatio(1f),
                        elevation = CardDefaults.cardElevation(3.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.bill4),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }

            Spacer(Modifier.height(16.dp))

            //row of buttons at last
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
//                .padding(24.dp),
                horizontalArrangement = Arrangement.Center
            ){
//            Button(
//                onClick = {}
//            ) {
//                Row() {
//                    Image(painter = painterResource(R.drawable.add), contentDescription = null, modifier = Modifier.size(20.dp))
//                    Text(text = "Add to amount")
//                }
//            }

                Button(onClick = onBack) {
                    Text("Back", style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}