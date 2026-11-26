package com.example.ushtrimi_2.home.gallery

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.example.ushtrimi_2.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FullScreenGalleryItem(
    drawableId: Int,
    onBack: () -> Unit
) {
    val context = LocalContext.current
    Scaffold(
        contentColor = Color.Black,
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {
                        shareImage(context)
                    }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_right),
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White
                )
            )

        }
    ) { innerpadding ->
        Image(
            painterResource(drawableId),
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(innerpadding),
            contentScale = ContentScale.Fit
        )
    }
}

fun shareImage(context: Context){
    val intentn = Intent(Intent.ACTION_SEND)
    intentn.type = "image/jpeg"
    intentn.putExtra("","")
    context.startActivity(Intent.createChooser(intentn,"Share Image "))
}