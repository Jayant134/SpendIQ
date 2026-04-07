package com.example.spendiq.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.spendiq.R


val Lexend = FontFamily(
    Font(R.font.lexend_light),
    Font(R.font.lexend_regular),
    Font(R.font.lexend_bold)
)
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = Lexend,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    titleSmall = TextStyle(
        fontFamily = Lexend,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
//    bodyLarge = TextStyle(
//        fontFamily = Lexend,
//        fontWeight = FontWeight.Normal,
//        fontSize = 22.sp
//    ),
    bodyMedium = TextStyle(
        fontFamily = Lexend,
        fontWeight = FontWeight.Light,
        fontSize = 16.sp
    )
)

val DisplayXLargeBold = TextStyle(
    fontFamily = Lexend,
    fontWeight = FontWeight.Bold,
    fontSize = 28.sp
)
