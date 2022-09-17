package com.example.alphabetbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class AlphabetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alphabet)

        val presenter = AlphabetPresenter(intent, applicationContext)
        presenter.displayToast()

        var imageView = findViewById<ImageView>(R.id.imageView)
        presenter.loadImage(imageView, resources, packageName)

        // A button
        var firstPageButton = findViewById<Button>(R.id.firstPage)
        presenter.addClickListener(firstPageButton, firstPageButton.text as String, ::startActivity)

        // Z button
        var lastPageButton = findViewById<Button>(R.id.lastPage)
        presenter.addClickListener(lastPageButton, lastPageButton.text as String, ::startActivity)

        // Previous button
        val prevButton = findViewById<Button>(R.id.previous)
        val prevChar = presenter.getPrevAlpha()
        presenter.addClickListener(prevButton, prevChar.toString(), ::startActivity)

        // Next button
        val nextButton = findViewById<Button>(R.id.next)
        val nextChar = presenter.getNextAlpha()
        presenter.addClickListener(nextButton, nextChar.toString(), ::startActivity)



    }
}