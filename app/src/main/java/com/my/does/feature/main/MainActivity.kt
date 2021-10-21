package com.my.does.feature.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.my.does.feature.navigation.navigationTo
import com.my.does.feature.screens.BasicScreen
import com.my.does.ui.theme.ToDoTheme

class MainActivity : ComponentActivity() {
    private val model: ViewModelMain by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoTheme {
                val navController = rememberNavController()
                BasicScreen(navController , model )
                model.isScreen.observe(this){
                    navController.navigationTo(it)
                }

            }
        }
    }

}