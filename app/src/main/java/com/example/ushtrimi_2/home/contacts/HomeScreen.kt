package com.example.ushtrimi_2.home.contacts

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ushtrimi_2.R
import kotlin.uuid.Uuid


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onContactClicked: (String) -> Unit
) {
    val repo = remember { ContactsRepo() }
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

            }) {
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
                    onClick = { },
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
                    onClick = { },
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
            modifier = Modifier.padding(innerPadding),
            onContactClicked = onContactClicked
        )

    }
}

@Composable
fun ContactsList(
    contacts: List<ContactsUIModel>, modifier: Modifier = Modifier,
    onContactClicked: (String) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            contacts,
            key = { it.id }) { contact ->
            ContactRow(contact, onContactClicked)
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
fun ContactRow(
    contact: ContactsUIModel,
    onContactClicked: (String) -> Unit
) {
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onContactClicked.invoke(contact.id)

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

