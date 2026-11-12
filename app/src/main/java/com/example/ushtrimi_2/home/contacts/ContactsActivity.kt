package com.example.ushtrimi_2.home.contacts

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ushtrimi_2.home.contacts.ui.theme.Ushtrimi_2Theme

class ContactsActivity : ComponentActivity() {


    private val TAG  = ContactsActivity::class.simpleName
private val repo : ContactsRepo = ContactsRepo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ushtrimi_2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ContactsList(
                        list = repo.getContacts(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

    }
}

@Composable
fun ContactsList(list: List<ContactsUIModel>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier

    ) {
        item { Text(text = "${list[0].firstName}") }
    }

}
