package com.example.ushtrimi_2.home.gallery

import android.util.Log
import com.example.ushtrimi_2.R

class GalleryRepo(
) {

    fun loadGalleryImages(contactId:String ): List<Int>{
        Log.d("GalleryRrepo","Loading images for contact with contactId: ${contactId}")
        return listOf(
            R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,
            R.drawable.img_4,R.drawable.img_5,R.drawable.img_6, R.drawable.img_16,
            R.drawable.img_7, R.drawable.img_8, R.drawable.img_9, R.drawable.img_11,
            R.drawable.img_10,
            R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,
            R.drawable.img_4,R.drawable.img_5,R.drawable.img_6, R.drawable.img_16,
            R.drawable.img_7, R.drawable.img_8, R.drawable.img_9, R.drawable.img_11,
            R.drawable.img_10,
            R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,
            R.drawable.img_4,R.drawable.img_5,R.drawable.img_6, R.drawable.img_16,
            R.drawable.img_7, R.drawable.img_8, R.drawable.img_9, R.drawable.img_11,
            R.drawable.img_10
        )
    }
}
