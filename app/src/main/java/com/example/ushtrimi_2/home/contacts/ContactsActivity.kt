package com.example.ushtrimi_2.home.contacts

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.IntentCompat
import com.example.ushtrimi_2.R
import com.example.ushtrimi_2.home.contacts.ui.theme.Ushtrimi_2Theme
import com.example.ushtrimi_2.home.gallery.GalleryActivity
import practice_1.Circle

class ContactsActivity : ComponentActivity() {


    private val TAG = ContactsActivity::class.simpleName
    private val repo: ContactsRepo = ContactsRepo()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ushtrimi_2Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = stringResource(R.string.contacts),
                                    style = MaterialTheme.typography.headlineLarge
                                )
                            }
                        )
                    },
                    floatingActionButton = {
                        FloatingActionButton(onClick = {

                        }){
                            Icon(
                                painter = painterResource(R.drawable.ic_add),
                                contentDescription = null
                            )
                        }
                    },
                    bottomBar = {
                        NavigationBar {
                            NavigationBarItem(
                                selected = true,
                                onClick = {  },
                                icon = {
                                    Icon(
                                        painter = painterResource(R.drawable.ic_person),
                                        contentDescription = ""
                                    )
                                },
                                label = { Text(stringResource(R.string.contacts)) }
                            )
                            NavigationBarItem(
                                selected = true,
                                onClick = {  },
                                icon = {
                                    Icon(
                                        painter = painterResource(R.drawable.ic_image),
                                        contentDescription = ""
                                    )
                                },
                                label = { Text("Gallery") }
                            )

                        }
                    }

                ) { innerPadding ->
                    ContactsList(
                        contacts = repo.getContacts(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

    }
}

@Composable
fun ContactsList(contacts: List<ContactsUIModel>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
    ) {
        /* stickyHeader {
             Text(
                 text = "Contacts",
                 style = MaterialTheme.typography.headlineLarge,
                 modifier = Modifier
                     .fillMaxWidth()
                     .background(MaterialTheme.colorScheme.background)
                     .padding(8.dp)
             )
         }*/

        items(
            contacts,
            key = { it.id }) { contact ->
            ContactRow(contact)
            HorizontalDivider(thickness = 0.5.dp)
        }

        item {
            Text(
                text = "End of Contacts",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(8.dp)
            )
        }
    }
}


@Composable
fun ContactRow(contact: ContactsUIModel) {
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                val intent = Intent(context, GalleryActivity::class.java)
                context.startActivity(intent)
            }
            .padding(8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,

        ) {

        Image(
            painter = painterResource(contact.avatarId),
            contentDescription = "",
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .clickable {
                    Log.d("ContactClicked", "Image clicked: ${contact.avatarId}")
                }
        )

        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
        ) {
            Text(
                text = contact.firstName + " " + contact.lastName,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = contact.email,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Image(
            painter = painterResource(R.drawable.ic_arrow_right),
            contentDescription = ""
        )

    }
}