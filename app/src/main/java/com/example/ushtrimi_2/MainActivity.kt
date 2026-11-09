package com.example.ushtrimi_2

import KotlinFund_2.FileLogger
import KotlinFund_2.LogcatHelper2
import KotlinFund_2.Logger
import KotlinFund_2.USerV3
import KotlinFund_2.User
import KotlinFund_2.demonstrateStudentShapesAndTasks
import android.R.attr.onClick
import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.widget.Button
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ushtrimi_2.reusableComponents.ReusableInputEmailField
import com.example.ushtrimi_2.ui.theme.Ushtrimi_2Theme
import com.example.ushtrimi_2.utils.validateUser

class MainActivity : ComponentActivity() {
    private val TAG = "MainActivity"
    var counter = 0


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
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ushtrimi_2Theme {
                var showSignUp by remember { mutableStateOf(false) }
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    if (showSignUp) {
                        SignUpScreen(
                            innerPadding = innerPadding,
                            onBackClick = { showSignUp = false }
                        )
                    } else {
                        LoginScreen(
                            innerPadding = innerPadding,
                            onSignUpClick = { showSignUp = true }
                        )
                    }
                }
            }
        }
        adress = "Cacttus education, rruga 50"

        demonstrateStudentShapesAndTasks()

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

        myLogger = FileLogger()
        val user3 = USerV3("Armend","Morina")
        println("testing dataclasses: ${user3.toString()}")
        println("testing dataclasses hashcode: ${user3.hashCode()}")
       val usrV31=  user3.copy(lastName = "Krasniqi")
        println("testing dataclasses: ${usrV31.toString()}")
      user.toString()



        firstName2 = getuserName(1, "")

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

    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState called.....")
        outState.putInt("Counter", counter)
    }

    override fun onDestroy() {
        super.onDestroy()
        firstName2 = null
        Log.d(TAG, "onDestroy called")
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




}
@Composable

fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )

}

//String getUserName(String arg1, String arg2...... ){
 //
//
//
//return "";


// }

fun getuserName(id: Int, token: String): String?{
    if (id == 0 ){
        return null
    }
    return token
    procesUserPayemnt()
}

fun procesUserPayemnt(){
    println("Payment processed successfully.....")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ushtrimi_2Theme {
        Greeting("Android")
    }
}

@Composable
fun LoginScreen(innerPadding: PaddingValues, onSignUpClick: () -> Unit){
    var email by remember {mutableStateOf("")}
    var password by remember {mutableStateOf("")}
    var loginButtonEnabled by remember {mutableStateOf(false)}
    val context = LocalContext.current
    var showErrorAlert = false


    Box(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ){
            Image(
                painter = painterResource(R.drawable.ic_lock),
                contentDescription = "",
                modifier = Modifier.size(100.dp)
            )

            Text(
                text = "Welcome back",
                style = MaterialTheme.typography.titleLarge
            )

//            var email = ""
            ReusableInputEmailField(
                value = email,
                event = { enteredEmail->
                    email = enteredEmail
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            ReusableInputEmailField(
                value = password,
                event = { enteredPassword->
                    password = enteredPassword
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation()
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    onClick ={
                        if (validateUser(email = email, password = password)){
                            Toast.makeText(context,"Email and password from user are correct",
                                Toast.LENGTH_LONG).show();
                        }else{
                            showErrorAlert = true

                        }
                    },
                    modifier = Modifier.weight(1f),
                    enabled = !email.isBlank() && !password.isBlank()
                ){
                    Text(text = "Login")
                }

                Button(
                    onClick = onSignUpClick,
                    modifier = Modifier.weight(1f)
                ){
                    Text(text = "Sign Up")
                }
            }


        }
    }
    if (showErrorAlert){
        AlertDialog(
        title = {
            Text(text = "Error")
        },
        text = {
            Text(text = "Please check you email or password")
        },
            onDismissRequest = {
                showErrorAlert = false
            },
            confirmButton = {
                TextButton(onClick = {showErrorAlert = false}) {
                    Text(text = "OK")
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

@Composable
fun SignUpScreen(innerPadding: PaddingValues, onBackClick: () -> Unit) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var agreedToTerms by remember { mutableStateOf(false) }
    var showPassword by remember { mutableStateOf(false) }

    val passwordVisualTransformation =
        if (showPassword) VisualTransformation.None else PasswordVisualTransformation()

    val passwordsMatch = password == confirmPassword
    val showPasswordMismatchError =
        confirmPassword.isNotEmpty() && password.isNotEmpty() && !passwordsMatch

    val isFormValid = firstName.isNotBlank() &&
            lastName.isNotBlank() &&
            email.isNotBlank() &&
            password.isNotBlank() &&
            confirmPassword.isNotBlank() &&
            passwordsMatch &&
            agreedToTerms

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
            Text(
                text = "Create account",
                style = MaterialTheme.typography.titleLarge
            )

            ReusableInputEmailField(
                value = firstName,
                event = { firstName = it },
                label = "First name"
            )

            ReusableInputEmailField(
                value = lastName,
                event = { lastName = it },
                label = "Last name"
            )

            ReusableInputEmailField(
                value = email,
                event = { email = it },
                label = "Email address",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            ReusableInputEmailField(
                value = password,
                event = { password = it },
                label = "Password",
                visualTransformation = passwordVisualTransformation,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Text(
                text = "Password must be at least 6 characters",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )

            ReusableInputEmailField(
                value = confirmPassword,
                event = { confirmPassword = it },
                label = "Confirm password",
                visualTransformation = passwordVisualTransformation,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            if (showPasswordMismatchError) {
                Text(
                    text = "Passwords do not match",
                    color = Color.Red,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Checkbox(
                    checked = agreedToTerms,
                    onCheckedChange = { agreedToTerms = it }
                )
                Text(text = "I agree to the Terms of Use")
            }

            TextButton(onClick = { showPassword = !showPassword }) {
                Text(text = if (showPassword) "Hide password" else "Show password")
            }

            Button(
                onClick = {
                    Log.d("SignUp", "First name: $firstName, Last name: $lastName, Email: $email")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                enabled = isFormValid
            ) {
                Text(text = "Create account")
            }

            TextButton(onClick = onBackClick) {
                Text(text = "Back to Login")
            }
        }
    }
}