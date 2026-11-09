package application

import android.app.Application
import android.util.Log

class ContactsApp : Application() {
    private val TAG = "ContactsApp"
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "Application instace created")
    }
}