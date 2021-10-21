package com.my.does.feature.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.my.does.data.Task
import com.my.does.feature.main.ViewModelMain
import com.my.does.feature.screens.TasksScreen
import com.my.does.feature.screens.WelcomeScreen



@ExperimentalAnimationApi
@Composable
fun NavigationAppToDo(navController: NavHostController, modifier: Modifier  , viewModelMain: ViewModelMain) {
    NavHost(navController = navController, startDestination = ScreenRout.Welcome.route , modifier) {
        composable(ScreenRout.Welcome.route) { WelcomeScreen() }
        mainGraph(navController, viewModelMain)
    }
}

@ExperimentalAnimationApi
fun NavGraphBuilder.mainGraph(navController:NavHostController, viewModelMain: ViewModelMain) {
    navigation(startDestination = ScreenRout.Main.Tasks.route, route = ScreenRout.Main.route) {
        composable(ScreenRout.Main.Tasks.route) {
            val listTask = remember { viewModelMain.listTasks }
            TasksScreen(listTask){ viewModelMain.toCreateTask() }
        }
        composable(ScreenRout.Main.CreateTask.route) { }
      //  composable(NavigationScreen.Main.OpenTask.route) { }
    }
}


fun NavHostController.navigationTo(place:Int){
    val route = currentBackStackEntry?.destination?.route ?: return
    when(place){
        0 -> navigate(ScreenRout.Welcome.route)
        1 -> if (route != ScreenRout.Main.route)
            navigate(ScreenRout.Main.route){ popUpTo(ScreenRout.Welcome.route){inclusive = true} }
        2 -> navigate(ScreenRout.Main.CreateTask.route)
    }
}