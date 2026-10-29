package com.example.ushtrimi_2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.ushtrimi_2.ui.theme.Ushtrimi_2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Ushtrimi_2Theme {
                PracticeScreen()
            }
        }
    }
}

@Composable
fun PracticeScreen() {
    val context = LocalContext.current
    val student = Student("Armend", 10.0)

    val shapes: List<Shape> = listOf(
        Circle(5.0),
        Rect(4.0, 6.0)
    )

    val tasks = listOf(
        Task("Mëso Kotlin", Priority.HIGH),
        Task("Bli ushqime", Priority.LOW),
        Task("Përfundo projektin", Priority.HIGH),
        Task("Lexo dokumentacionin", Priority.MEDIUM),
        Task("Dërgo email", Priority.HIGH)
    )

    val highPriorityTitles = tasks
        .filter { task -> task.priority == Priority.HIGH }
        .joinToString("\n") { task -> "- ${task.title}" }

    val groupedTasks = tasks
        .groupBy { task -> task.priority }
        .entries
        .joinToString("\n") { (priority, taskList) ->
            "$priority: ${taskList.size} task-e"
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = "Ushtrime Kotlin",
            style = MaterialTheme.typography.headlineSmall
        )

        Text(text = "\nStudenti: ${student.name}")
        Text(text = "Nota: ${student.grade}")

        Text(text = "\nSipërfaqet:")
        shapes.forEachIndexed { index, shape ->
            Text(text = "Forma ${index + 1}: ${shape.area()}")
        }

        Text(text = "\nTask-et me prioritet HIGH:")
        Text(text = highPriorityTitles)

        Text(text = "\nNumri i task-eve sipas prioritetit:")
        Text(text = groupedTasks)

        Button(
            onClick = {
                val intent = Intent(context, DetailsActivity::class.java).apply {
                    putExtra(DetailsActivity.EXTRA_STUDENT_NAME, student.name)
                    putExtra(DetailsActivity.EXTRA_STUDENT_GRADE, student.grade.toInt())
                }
                context.startActivity(intent)
            }
        ) {
            Text(text = "Hap detajet")
        }
    }
}