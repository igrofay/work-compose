package com.my.does.feature.navigation

sealed class ScreenRout(val route: String){
    object Welcome : ScreenRout("welcome_screen")
    object Main : ScreenRout("main_screen"){
        object Tasks : ScreenRout("tasks_screen")
        object CreateTask : ScreenRout("create_task_screen")
        object OpenTask : ScreenRout("open_task_screen/{id}")
    }
}
