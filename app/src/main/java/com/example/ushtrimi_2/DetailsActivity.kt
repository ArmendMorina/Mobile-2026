package com.example.ushtrimi_2

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.ComponentActivity

class DetailsActivity: ComponentActivity() {
    private val TAG = "DetailActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        val counter = intent.getIntExtra(EXTRA_COUNTER, 0)

        Log.d(TAG, "onCreate called")
        Log.d(TAG, "Received message: $message")
        Log.d(TAG, "Received counter: $counter")
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

    companion object {
        const val EXTRA_MESSAGE = "extra_message"
        const val EXTRA_COUNTER = "extra_counter"
    }

}