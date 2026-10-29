package com.example.ushtrimi_2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ushtrimi_2.ui.theme.Ushtrimi_2Theme

class DetailsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val studentName = intent.getStringExtra(EXTRA_STUDENT_NAME).orEmpty()
        val studentGrade = intent.getIntExtra(EXTRA_STUDENT_GRADE, 0)

        Log.d(TAG, "onCreate: name=$studentName, grade=$studentGrade")

        setContent {
            Ushtrimi_2Theme {
                Column(modifier = Modifier.padding(24.dp)) {
                    Text(text = "Studenti: $studentName")
                    Text(text = "Nota: $studentGrade")
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        Log.d(TAG, "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "onStop")
        super.onStop()
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }

    companion object {
        private const val TAG = "DetailsActivity"
        const val EXTRA_STUDENT_NAME = "extra_student_name"
        const val EXTRA_STUDENT_GRADE = "extra_student_grade"
    }
}
