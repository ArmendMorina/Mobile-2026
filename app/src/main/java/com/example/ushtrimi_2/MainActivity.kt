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
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ushtrimi_2.reusableCoomposable.ReusableInputFiled
import com.example.ushtrimi_2.ui.theme.Ushtrimi_2Theme
import com.example.ushtrimi_2.utlis.validateUser
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
                    LoginScreen(
                        innerPadding = innerPadding,
                        onLoginSuccess = {
                            counter ++
                            Log.d(TAG,"Counter value is: ${counter}")

                            // Open the Details screen and pass data to it
                            val detailsActivity = Intent(this, DetailsActivity::class.java)
                            detailsActivity.putExtra(DetailsActivity.EXTRA_MESSAGE, "Opened from MainActivity")
                            detailsActivity.putExtra(DetailsActivity.EXTRA_COUNTER, counter)
                            startActivity(detailsActivity)
                        },
                        onSignUpClick = {
                            // Open the Sign Up screen
                            startActivity(Intent(this, SignUpActivity::class.java))
                        }
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

@Composable
fun LoginScreen(
    innerPadding: PaddingValues,
    onLoginSuccess: () -> Unit,
    onSignUpClick: () -> Unit
) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current
    var showErrorAlert by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_lock),
                contentDescription = "",
                modifier = Modifier.size(100.dp)
            )

            Text(
                text = "Welcome back",
                style = MaterialTheme.typography.headlineLarge
            )
            //email
            ReusableInputFiled(
                value = email,
                event = {enteredEmail->
                  email = enteredEmail
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                label = "Email"
            )

            //password
            ReusableInputFiled(
               value = password,
               event = {eneteredPassword->
                   password = eneteredPassword
               },
               keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
               visualTransformation = PasswordVisualTransformation(),
               label = "Password"
           )

            // Login and Sign Up next to each other
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
            ) {
                Button(
                    onClick = {
                        if (validateUser(email = email, password = password)){
                            Toast.makeText(context,"Email and password from user are correct",
                                Toast.LENGTH_LONG).show();
                            onLoginSuccess()
                        }else{
                            showErrorAlert = true
                        }
                    },
                    modifier = Modifier.weight(1f),
                    enabled = !email.isBlank() && !password.isBlank()
                ) {
                    Text(text = "Login")
                }

                Button(
                    onClick = onSignUpClick,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Sign Up")
                }
            }
        }
    }

    if (showErrorAlert){
        AlertDialog(
            title = {Text(text = "Something went wrong")},
            text = {Text(text = "Please check your email  or password ")},
            onDismissRequest = {
                showErrorAlert = false
            },
            confirmButton ={
                TextButton(onClick = {showErrorAlert = false}) {
                    Text(text = "Ok")
                }
            },
            dismissButton = {
                TextButton(onClick = {showErrorAlert = false}) {
                    Text(text = "Cancel")
                }
            }
        )
    }





}
