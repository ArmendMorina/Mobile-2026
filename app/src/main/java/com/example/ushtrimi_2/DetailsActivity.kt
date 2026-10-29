package com.example.ushtrimi_2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text

class DetailsActivity : ComponentActivity() {

    private val TAG = "DetailsActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate called")

        val name = intent.getStringExtra("EXTRA_NAME") ?: "No name"
        val counter = intent.getIntExtra("EXTRA_COUNTER", -1)

        Log.d(TAG, "Received name: $name")
        Log.d(TAG, "Received counter: $counter")

        setContent {
            Text("Hello $name, counter = $counter")
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called")
    }
}