package com.example.alphabetbook

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.ImageView

class AlphabetModel(_image: String, _imageView: ImageView, _resources: Resources, _packageName: String): Thread() {
    private var imageName = _image
    private var imageView = _imageView
    private var resources = _resources
    private var packageName = _packageName

    override fun run() {
        var id = resources.getIdentifier(imageName, "drawable", packageName)
        var bitmap = BitmapFactory.decodeResource(resources, id)
        imageView.setImageBitmap(bitmap)
    }

    fun loadImage() {
        start()
    }
}