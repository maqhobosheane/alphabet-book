package com.example.alphabetbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class AlphabetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alphabet)

        val presenter = AlphabetPresenter(intent, applicationContext)
        presenter.displayToast()

        var imageView = findViewById<ImageView>(R.id.imageView)
        presenter.loadImage(imageView, resources, packageName)


    }
}