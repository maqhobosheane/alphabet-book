package com.example.alphabetbook

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create an empty alphabets array
        val alphabets = Array(26){""}

        // Add letters to array
        for (alpha in 65..90){
            alphabets[alpha - 65] = alpha.toChar().toString()
        }

        // find grid view items, i.e., alphabet buttons
        val alphabetGrid = findViewById<GridView>(R.id.gridView)

        // set the adapter of gridview to buttons
        alphabetGrid.adapter = object : ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alphabets) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

                return (super.getView(position, convertView, parent) as TextView)
                    .apply {
                        // Center the text
                        gravity = Gravity.CENTER
                        // Change text color to white
                        setTextColor(Color.WHITE)
                        // Set background color
                        setBackgroundColor(Color.parseColor("#FF3700B3"))
                    }
            }
        }
        // handle what to do when the grid view item is clicked
        // i.e., when any alphabet button is clicked
        alphabetGrid.setOnItemClickListener { _, _, i, _ ->
            val intent = Intent(applicationContext, AlphabetActivity::class.java)
            intent.putExtra("name", alphabets[i])
            startActivity(intent)
        }
    }
}