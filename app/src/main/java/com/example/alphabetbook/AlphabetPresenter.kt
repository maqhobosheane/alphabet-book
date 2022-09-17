package com.example.alphabetbook

import android.content.Context
import android.content.Intent
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

}