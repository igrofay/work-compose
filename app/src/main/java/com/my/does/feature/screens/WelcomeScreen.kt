package com.my.does.feature.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.my.does.R
import com.my.does.ui.theme.colorTextW


@Composable
fun WelcomeScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(colors.primary),
        Arrangement.Center , Alignment.CenterHorizontally
        ){
        Image(painter = painterResource(R.drawable.ic_app), contentDescription = "icon app",
        Modifier.size(120.dp))
        Text("TO\nDO" , fontWeight = FontWeight.Bold , fontSize = 36.sp , color = colors.colorTextW)

    }
}