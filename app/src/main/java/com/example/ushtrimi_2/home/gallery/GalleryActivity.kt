package com.example.ushtrimi_2.home.gallery

import android.media.Image
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ushtrimi_2.R

class GalleryActivity : androidx.activity.ComponentActivity() {

    private val galleryRepo = GalleryRepo()
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("Images") },
                        navigationIcon = {
                            IconButton(onClick = {
                                this.finish()
                            }) {
                                Icon(
                                    painter = painterResource(R.drawable.ic_arrow_back),
                                    contentDescription = "Back"
                                )
                            }
                        }
                    )
                }

            ){ innerPadding ->
                GalleryList(
                    modifier = Modifier.padding(innerPadding),
                    images = galleryRepo.loadGalleryImages()
                )

            }
        }
    }
}

@Composable
fun GalleryList(modifier: Modifier, images: List<Int>) {
    LazyVerticalGrid(
        modifier = modifier.fillMaxSize(),
        columns = GridCells.Adaptive(120.dp),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        items(images) { image ->
            GalleryItem(image)
        }
    }
}

@Composable
fun GalleryItem(imageId : Int){
    androidx.compose.foundation.Image(
        painter = painterResource(imageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.aspectRatio(1f)
    )
}