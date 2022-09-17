package com.example.alphabetbook

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Resources
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class AlphabetPresenter (_intent: Intent, _context: Context) {
    // Create intent and context properties
    private var intent = _intent
    private var context = _context

    // Get the alphabet name from intent
    var alphabet = intent.getStringExtra("letter") ?: ""

    // displays Toast: The alphabet e.g., A
    fun displayToast() {
        Toast.makeText(context, alphabet, Toast.LENGTH_LONG).show()
    }

    // Load image
    fun loadImage(imageView: ImageView, resources: Resources, packageName: String) {
        val model = AlphabetModel(alphabet.lowercase(), imageView, resources, packageName)
        model.loadImage()
    }

    // Add click listener
    fun addClickListener(button: Button, letter: String, startActivity: (intent: Intent) -> Unit) {
        button.setOnClickListener {
            var intent = Intent(context, AlphabetActivity::class.java)
            intent.putExtra("letter", letter)
            startActivity(intent)
        }
    }

    // Finds the previous alphabet
    fun getPrevAlpha(): Char {
        val currentChar: Char = alphabet[0]
        return if (currentChar == 65.toChar()) 90.toChar() else (currentChar - 1)
    }

    // Finds the next alphabet
    fun getNextAlpha(): Char {
        val currentChar: Char = alphabet[0]
        return if (currentChar == 90.toChar()) 65.toChar() else (currentChar + 1)
    }
}