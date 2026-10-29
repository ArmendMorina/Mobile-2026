package com.example.ushtrimi_2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity

class DetailsActivity: ComponentActivity() {

    private val TAG  = "DetailsActivity"

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_COUNTER = "extra_counter"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"OnCreate called")

        val name = intent.getStringExtra(EXTRA_NAME)
        val counter = intent.getIntExtra(EXTRA_COUNTER, 0)
        Log.d(TAG,"Received name: ${name}")
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
