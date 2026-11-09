package com.example.ushtrimi_2

import KotlinFund_2.FileLogger
import KotlinFund_2.LogcatHelper2
import KotlinFund_2.Logger
import KotlinFund_2.Student
import KotlinFund_2.USerV3
import KotlinFund_2.User
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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
                    var showSignUp by remember { mutableStateOf(false) }
                    if (showSignUp) {
                        SignUpScreen(
                            modifier = Modifier.padding(innerPadding),
                            onBackToLogin = { showSignUp = false }
                        )
                    } else {
                        LoginScreen(
                            modifier = Modifier.padding(innerPadding),
                            onSignUpClick = { showSignUp = true }
                        )
                    }
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
fun LoginScreen(
    modifier: Modifier = Modifier,
    onSignUpClick: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Login", style = MaterialTheme.typography.headlineMedium)
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email address") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(onClick = {}, modifier = Modifier.weight(1f)) {
                Text("Login")
            }
            Button(onClick = onSignUpClick, modifier = Modifier.weight(1f)) {
                Text("Sign Up")
            }
        }
    }
}

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    onBackToLogin: () -> Unit
) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var termsAccepted by remember { mutableStateOf(false) }
    var showPassword by remember { mutableStateOf(false) }

    val passwordsMatch = password == confirmPassword
    val formIsComplete = listOf(firstName, lastName, email, password, confirmPassword)
        .all { it.isNotBlank() }
    val canCreateAccount = formIsComplete && passwordsMatch && termsAccepted
    val passwordTransformation =
        if (showPassword) VisualTransformation.None else PasswordVisualTransformation()

    SignUpForm(
        modifier = modifier,
        firstName = firstName,
        onFirstNameChange = { firstName = it },
        lastName = lastName,
        onLastNameChange = { lastName = it },
        email = email,
        onEmailChange = { email = it },
        password = password,
        onPasswordChange = { password = it },
        confirmPassword = confirmPassword,
        onConfirmPasswordChange = { confirmPassword = it },
        termsAccepted = termsAccepted,
        onTermsAcceptedChange = { termsAccepted = it },
        showPassword = showPassword,
        onShowPasswordChange = { showPassword = it },
        passwordTransformation = passwordTransformation,
        passwordsMatch = passwordsMatch,
        canCreateAccount = canCreateAccount,
        onCreateAccount = {
            Log.d("SignUpScreen", "First name: $firstName, Last name: $lastName, Email: $email")
        },
        onBackToLogin = onBackToLogin
    )
}

@Composable
private fun SignUpForm(
    modifier: Modifier,
    firstName: String,
    onFirstNameChange: (String) -> Unit,
    lastName: String,
    onLastNameChange: (String) -> Unit,
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    confirmPassword: String,
    onConfirmPasswordChange: (String) -> Unit,
    termsAccepted: Boolean,
    onTermsAcceptedChange: (Boolean) -> Unit,
    showPassword: Boolean,
    onShowPasswordChange: (Boolean) -> Unit,
    passwordTransformation: VisualTransformation,
    passwordsMatch: Boolean,
    canCreateAccount: Boolean,
    onCreateAccount: () -> Unit,
    onBackToLogin: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Create account", style = MaterialTheme.typography.headlineMedium)
        OutlinedTextField(
            value = firstName,
            onValueChange = onFirstNameChange,
            label = { Text("First name") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = lastName,
            onValueChange = onLastNameChange,
            label = { Text("Last name") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = email,
            onValueChange = onEmailChange,
            label = { Text("Email address") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = password,
            onValueChange = onPasswordChange,
            label = { Text("Password") },
            supportingText = { Text("Password must be at least 6 characters") },
            visualTransformation = passwordTransformation,
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = onConfirmPasswordChange,
            label = { Text("Confirm password") },
            visualTransformation = passwordTransformation,
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        if (confirmPassword.isNotEmpty() && !passwordsMatch) {
            Text(
                text = "Passwords do not match",
                color = MaterialTheme.colorScheme.error
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onShowPasswordChange(!showPassword) },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = showPassword,
                onCheckedChange = null
            )
            Text("Show password")
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onTermsAcceptedChange(!termsAccepted) },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = termsAccepted,
                onCheckedChange = null
            )
            Text("I agree to the Terms of Use")
        }
        Button(
            onClick = onCreateAccount,
            enabled = canCreateAccount,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Create account")
        }
        TextButton(onClick = onBackToLogin) {
            Text("Back to login")
        }
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
