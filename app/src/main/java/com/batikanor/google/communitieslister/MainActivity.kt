package com.batikanor.google.communitieslister

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var timesClicked = 0
    val numCommunities = 12

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //< The setContentView method associates the layout with the activity, and then inflates the layout.

        val descriptionLabel: TextView = findViewById(R.id.description_label) //< Or I could use synthetic and directly reference description_label
        descriptionLabel
            .setOnClickListener { popDescriptionText() }
    }

    private fun popDescriptionText() {



        description_label.textSize = (description_label.textSize / resources.displayMetrics.scaledDensity) + if (timesClicked % 2 == 0) 1 else -1 //< Defaults to sp, no need to provide that as the first argument.

        Toast.makeText(this,
            "The description text was clicked " + (++timesClicked).toString() + " time(s)!",
            Toast.LENGTH_SHORT
        ).show()
    }
}