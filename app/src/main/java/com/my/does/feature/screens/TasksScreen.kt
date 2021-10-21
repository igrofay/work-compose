package com.my.does.feature.screens


import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.my.does.data.Task

@ExperimentalAnimationApi
@Composable
fun TasksScreen(list: SnapshotStateList<Task>, onClick: ()-> Unit ) {
    Box(Modifier.fillMaxSize()) {
        val listState = rememberLazyListState()

        LazyColumn(state = listState ,
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(list){
                itemTask(task = it)
            }
        }
        val showButton = remember {
            derivedStateOf {
                !listState.isScrollInProgress
            }
        }
        AnimatedVisibility(visible = showButton.value, modifier = Modifier
            .align(Alignment.BottomEnd),
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            FloatingActionButton(onClick = onClick, modifier = Modifier.padding(end = 20.dp, bottom = 35.dp) ) {
                Text("+", style = MaterialTheme.typography.h6)
            }
        }
    }
}

@Composable
fun itemTask(task: Task) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        elevation = 2.dp,
    )  {
        Column{
            Text(task.title,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(8.dp))
            if(task.description != ""){
                Text(task.description , maxLines = 3 ,
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(8.dp))
            }
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier
                    .padding(start = 8.dp)
                    .shadow(8.dp, RoundedCornerShape(25.dp))
                    .background(Color.LightGray)
                    .width(36.dp)
                    .height(20.dp)
                    .drawBehind {
                        val canvasWidth = size.width
                        val canvasHeight = size.height
                        drawCircle(
                            color = getColorDemandingLevel(task.demandingLevel),
                            center = Offset(x = canvasWidth / 3, y = canvasHeight / 2),
                            radius = size.minDimension / 4
                        )
                    })
                Spacer(modifier = Modifier.weight(1f))
                var isDone by remember { mutableStateOf(task.isDone) }
                Checkbox(checked = isDone,
                    onCheckedChange = {
                        task.isDone = it
                        isDone = it
                                      },
                modifier = Modifier.padding(vertical = 12.dp , horizontal = 16.dp))
            }
        }
    }
}

fun getColorDemandingLevel(demandingLevel:Int) = when(demandingLevel){
    0-> Color.Green
    1-> Color.Cyan
    2-> Color.Magenta
    3-> Color.Yellow
    4-> Color.Red
    else -> Color.LightGray
}



