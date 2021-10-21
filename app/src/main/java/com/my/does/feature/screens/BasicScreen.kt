package com.my.does.feature.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.my.does.feature.main.ViewModelMain
import com.my.does.feature.navigation.NavigationAppToDo

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BasicScreen(navController: NavHostController , viewModelMain: ViewModelMain) {
    Scaffold(
        topBar = {
            val route by viewModelMain.isScreen.observeAsState()
        }
    ) { innerPadding ->
        NavigationAppToDo( navController ,  Modifier.padding(innerPadding) , viewModelMain)
    }
}