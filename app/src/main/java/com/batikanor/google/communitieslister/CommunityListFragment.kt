package com.batikanor.google.communitieslister

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.batikanor.google.communitieslister.data.RetrofitProvider
import com.batikanor.google.communitieslister.data.CommunitiesAdapter
import com.batikanor.google.communitieslister.data.model.Community
import kotlinx.android.synthetic.main.fragment_community_list.*
import kotlinx.coroutines.launch


class CommunityListFragment : Fragment(R.layout.fragment_community_list) {

    var timesClicked = 0
    val numCommunities = 12



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            val response:List<Community>? = RetrofitProvider.communitiesMockApi.getCommunities()
            //response.communities?.get(0)
            recyclerViewCommunities.adapter = CommunitiesAdapter(response.orEmpty().toMutableList()){
                val direction = CommunityListFragmentDirections.actionCommunityListFragmentToCommunityFragment(it)
                findNavController().navigate(direction)

            }

        }


        description_label
            .setOnClickListener {
                popDescriptionText()
                //val num = (0..10).random()

            }






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