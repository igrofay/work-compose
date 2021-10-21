package com.my.does.feature.navigation

import androidx.navigation.NavHostController

fun NavHostController.navigationToolbarTo(place:Int){
    val route = currentBackStackEntry?.destination?.route ?: return
    when(place){
        0 -> navigate(ScreenRout.Welcome.route)
        1 -> if (route != ScreenRout.Main.route)
            navigate(ScreenRout.Main.route){ popUpTo(ScreenRout.Welcome.route){inclusive = true} }
        2 -> navigate(ScreenRout.Main.CreateTask.route)
    }
}