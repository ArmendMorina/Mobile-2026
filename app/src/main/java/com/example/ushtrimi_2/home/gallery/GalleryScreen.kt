package com.example.ushtrimi_2.home.gallery

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ushtrimi_2.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GalleryScreen(
    onBack: () -> Unit,
    onGalleryItemClicked: () -> Unit
) {
    val galleryRepo = remember { GalleryRepo() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Images") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        GalleryList(
            modifier = Modifier.padding(innerPadding),
            images = galleryRepo.loadGalleryImages(),
            onGalleryItemClicked = onGalleryItemClicked
        )
    }
}

@Composable
fun GalleryList(
    modifier: Modifier, images: List<Int>,
    onGalleryItemClicked: () -> Unit
) {
    LazyVerticalGrid(
        modifier = modifier.fillMaxSize(),
        columns = GridCells.Adaptive(120.dp),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        items(images) { image ->
            GalleryItem(
                image,
                onGalleryItemClicked
            )
        }
    }
}

@Composable
fun GalleryItem(
    imageId: Int,
    onGalleryItemClicked: () -> Unit
) {
    androidx.compose.foundation.Image(
        painter = painterResource(imageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.aspectRatio(1f)
            .clickable{
                onGalleryItemClicked.invoke()
            }
    )
}