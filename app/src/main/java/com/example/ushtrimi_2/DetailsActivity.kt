package com.example.ushtrimi_2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity

class DetailsActivity: ComponentActivity() {

    private val TAG  = "DetailsActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"OnCreate called")

        val firstName = intent.getStringExtra("firstName")
        val age = intent.getIntExtra("age", 0)
        val counter = intent.getIntExtra("counter", 0)

        Log.d(TAG,"Received firstName: ${firstName}")
        Log.d(TAG,"Received age: ${age}")
        Log.d(TAG,"Received counter: ${counter}")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"OnStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"OnResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"OnPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"OnStop called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"OnRestart called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"OnDestroy called")
    }
}
