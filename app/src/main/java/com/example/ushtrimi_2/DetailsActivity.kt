package com.example.ushtrimi_2

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.ComponentActivity

class DetailsActivity: ComponentActivity() {

    private val TAG  = "DetailsActivity"

    // This is called on special case from Android after reboot.
  /*  override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        Log.d(TAG,"DetailsActivity created....")
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"DetailsActivity created....")
    }

}