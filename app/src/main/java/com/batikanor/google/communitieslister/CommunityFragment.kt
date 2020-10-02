package com.batikanor.google.communitieslister

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_community.*

class CommunityFragment : Fragment(R.layout.fragment_community) {
    private val navArgs by navArgs<CommunityFragmentArgs>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        random_number_text.text = navArgs.community.description

    }


}