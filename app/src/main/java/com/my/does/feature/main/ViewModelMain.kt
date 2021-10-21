package com.my.does.feature.main

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.my.does.data.Task
import com.my.does.data.WorkWithDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread

class ViewModelMain : ViewModel() {
    val listTasks  = mutableStateListOf<Task>(
        Task(1,"Помыть посуду", "fdafasfdfd", 3 , false),
                Task(2,"Убраться", "", 2 , false)
    )
    private val _isScreen = MutableLiveData(-1)
    val isScreen : LiveData<Int> get() = _isScreen
    init{
        viewModelScope.launch {
            doWork()
        }
    }
    private suspend fun doWork() = withContext(Dispatchers.IO) {
        val listT =  WorkWithDB.taskDao.getAll()
        try {
            listTasks +=  WorkWithDB.taskDao.getAll()
            _isScreen.postValue(1)
        }catch (e: Exception){
            withContext(Dispatchers.Main) {
                listTasks += listT
                _isScreen.value = 1
            }
        }
    }
    fun toCreateTask() { _isScreen.value = 2 }
}
