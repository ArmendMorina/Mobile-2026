package com.example.ushtrimi_2

import KotlinFund_2.FileLogger
import KotlinFund_2.LogcatHelper2
import KotlinFund_2.Logger
import KotlinFund_2.Student
import KotlinFund_2.USerV3
import KotlinFund_2.User
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ushtrimi_2.ui.theme.Ushtrimi_2Theme
import practice_1.runPractice

class MainActivity : ComponentActivity() {

    private val TAG = "MainActivity"

    private var counter = 0

    val firstName = "Armend"
    val age = 30
    var adress: String = "Cacttus education , rruga 40"
    val lastName: String = "Morina"

    val color = 2

    // Nullable
    var firstName2: String? = null

    // lateinit
    private lateinit var myLogger: Logger
    lateinit var loggedinUser: String
    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Restore state first
        counter = savedInstanceState?.getInt("Counter") ?: 0
        Log.d(TAG, "OnCreate called")
        Log.d(TAG, "Actual counter value is: $counter")

        enableEdgeToEdge()

        // Lists
        val listOfStringV2 = mutableListOf<String>()
        listOfStringV2.add("armend")
        listOfStringV2.add("morina")
        listOfStringV2.add("kaktuss")
        listOfStringV2.add("kaktuss")
        listOfStringV2.add("kaktuss")

        val editedList = listOfStringV2.map { currentString ->
            currentString.plus("\n")
        }
        println(editedList)

        val listOfUSers = mutableListOf<User>()
        listOfUSers.add(User("", ""))
        println("List of string: $listOfStringV2")

        val userids = mutableSetOf<String>()
        userids.add("")

        // Initialization of Kotlin classes
        user = User("test@test.test", "1234567890")
        user.updateFirstname("Armend")
        user.updateLastname("Morina")
        user.updateAge(19999)
        user.firstname = "someuser"
        println("Actual user toString()" + user.toString())
        println("Actual user hashCode: " + user.hashCode())

        myLogger = LogcatHelper2()
        myLogger = FileLogger()

        val student = Student("", "")

        // Data classes
        val user3 = USerV3("Armend", "Morina")
        println("testing dataclasses: ${user3}")
        println("testing dataclasses hashcode: ${user3.hashCode()}")
        val usrV31 = user3.copy(lastName = "Krasniqi")
        println("testing dataclasses: $usrV31")

        user = student
        user.toString()

        loggedinUser = "Hello $firstName"

        when (color) {
            2 -> {}
            1 -> {}
            499 -> {}
            else -> {}
        }

        runPractice()

        setContent {
            Ushtrimi_2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "cacttus",
                        modifier = Modifier
                            .padding(innerPadding)
                            .clickable {
                                counter++
                                Log.d(TAG, "Counter value is: $counter")

                                val detailsActivity = Intent(this@MainActivity, DetailsActivity::class.java).apply {
                                    putExtra("EXTRA_NAME", "Lorik")
                                    putExtra("EXTRA_COUNTER", counter)
                                }
                                startActivity(detailsActivity)
                            }
                            .size(320.dp)
                            .background(Color.Red)
                    )
                }
            }
        }

        adress = "Cacttus education, rruga 50"
        val count = firstName2?.length
        println("Numri i karaktereve eshte  $count")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState called.....")
        outState.putInt("Counter", counter)
    }

    override fun onDestroy() {
        super.onDestroy()
        firstName2 = null
        Log.d(TAG, "OnDestroy called")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "OnStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "OnResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "OnPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "OnStop called")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ushtrimi_2Theme {
        Greeting("Android")
    }
}