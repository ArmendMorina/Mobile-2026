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

    private  val TAG = "MainActivity"

    private var counter  = 0

    val firstName = "Armend"
    val age = 30
    var adress: String = "Cacttus education , rruga 40"
    val lastName: String = "Morina"

    // lateInit

    val color = 2
    //Nullable
    var firstName2: String? = null
    private lateinit var myLogger: Logger

    lateinit var loggedinUser: String

    lateinit var user : User


    override fun onCreate(savedInstanceState: Bundle?) {

       /* val listOfString = listOf("armend","morina","kaktus")
       val returnedElement =  listOfString.get(2)
        println("Returned element is: $returnedElement")*/

        val listOfStringV2 = mutableListOf<String>()
        listOfStringV2.add("armend")
        listOfStringV2.add("morina")
        listOfStringV2.add("kaktuss")
        listOfStringV2.add("kaktuss")
        listOfStringV2.add("kaktuss")



        //println("requested elemntis : ${k}")

        val editedList = listOfStringV2.map { curerntString->
            curerntString.plus("\n")
        }
        println(editedList)

      /*  val integers = listOf(2,3,4,5,6)
        integers.map { curentInt->
            if (curentInt% 2==0){
                curentInt ++
            }

        }*/

    /*  val edditedList =  listOfStringV2.forEach { actuaString->

          val editedList  = mutableListOf<String>()
         editedList.add( actuaString.plus("\n"))
          return@forEach editedList
        }
*/
        /*for (i in listOfStringV2){
            if (i == "kaktuss"){
                println("elemt is inside the list")
            }else{
                println("Current element is: ${i}")
            }

        }
        */



        val listOfUSers = mutableListOf<User>()
        listOfUSers.add(User("",""))
        println("List of string: ${listOfStringV2}")

        val userids  = mutableSetOf<String>()
        userids.add("")

        //initialziation of kotlin classes
        user = User("test@test.test","1234567890")

        user.updateFirstname("Armend")
        user.updateLastname("Morina")
        user.updateAge(19999)
        user.firstname = "someuser"
        println("Actual user toString()"+ user.toString())
        println("Actual user hashCode: " + user.hashCode())

        myLogger = LogcatHelper2()

        //

        //
        //
        //
        myLogger = FileLogger()
        val student = Student("","")

        val user3 = USerV3("Armend","Morina")
        println("testing dataclasses: ${user3.toString()}")
        println("testing dataclasses hashcode: ${user3.hashCode()}")
       val usrV31=  user3.copy(lastName = "Krasniqi")
        println("testing dataclasses: ${usrV31.toString()}")
        user = student
      user.toString()




        //String firstName = "Armend";
        loggedinUser = "Hello" + firstName

        when(color){
            2 ->{

            }
            1->{

            }
            499->{

            }
            else -> {

            }

        }


        super.onCreate(savedInstanceState)
        runPractice()
        enableEdgeToEdge()
        setContent {
            Ushtrimi_2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "cacttus",
                        modifier = Modifier
                            .padding(innerPadding)
                            .clickable() {
                                counter ++
                                Log.d(TAG,"Counter value is: ${counter}")

                                val detailsActivity = Intent(this, DetailsActivity::class.java)
                                detailsActivity.putExtra("firstName", firstName)
                                detailsActivity.putExtra("age", age)
                                detailsActivity.putExtra("counter", counter)
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
        println("Numri i karaktereve eshte  ${count}")
        Log.d(TAG,"OnCreate called")
        Log.d(TAG,"Actual counter value is: ${savedInstanceState?.getInt("Counter")?:0}")
        counter = savedInstanceState?.getInt("Counter")?:0
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG,"onSaveInstanceState called.....")
        outState.putInt("Counter",counter)
    }


    override fun onDestroy() {
        super.onDestroy()
        firstName2 = null
        Log.d(TAG,"OnDestroy called")

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