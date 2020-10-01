package com.batikanor.google.communitieslister

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_community_list.*
import kotlinx.android.synthetic.main.fragment_community_list.description_label


class CommunityListFragment : Fragment(R.layout.fragment_community_list) {

    var timesClicked = 0
    val numCommunities = 12



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        description_label
            .setOnClickListener { popDescriptionText() }
    }


    private fun popDescriptionText() {

        //val descriptionLabel: TextView = findViewById(R.id.description_label) //< Or I could use synthetic and directly reference description_label
        description_label.textSize = (description_label.textSize / resources.displayMetrics.scaledDensity) + if (++timesClicked % 2 == 1) 1 else -1 //< Defaults to sp, no need to provide that as the first argument.

        Toast.makeText(activity,
            "The description text was clicked " + (timesClicked).toString() + " time(s)!",
            Toast.LENGTH_SHORT
        ).show()
    }


}