package com.example.ushtrimi_2.home.contacts

import com.example.ushtrimi_2.R
import java.util.UUID
import kotlin.uuid.Uuid

class ContactsRepo {

    private val avatars = listOf(
        R.drawable.avatar_1, R.drawable.avatar_2, R.drawable.avatar_3,
        R.drawable.avatar_4, R.drawable.avatar_5, R.drawable.avatar_6,
        R.drawable.avatar_7, R.drawable.avatar_8, R.drawable.avatar_9,
        R.drawable.avatar_10, R.drawable.avatar_11, R.drawable.avatar_12
    )


    fun getContacts(): List<ContactsUIModel> = List(100){index->
        val currentUser = index+1
        ContactsUIModel(
            firstName = "Firstname ${currentUser}",
            lastName = "Lastname ${currentUser}",
            email = "firstName${currentUser}.lastname${currentUser}@example.om",
            id = UUID.randomUUID().toString(),
            avatarId =  avatars[index % avatars.size]
        )
    }


}

data class ContactsUIModel(
    val firstName: String ,
    val lastName : String,
    val email: String,
    val id : String ,
    val avatarId: Int
)




