package com.batikanor.google.communitieslister

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.net.Uri
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import coil.transform.CircleCropTransformation
import kotlinx.android.synthetic.main.fragment_community.*

class CommunityFragment : Fragment(R.layout.fragment_community) {
    private val navArgs by navArgs<CommunityFragmentArgs>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        textViewCommunityDescription.text = navArgs.community.description
        imageViewLeaderPhoto.load(navArgs.community.leader?.photo){
            crossfade(true)
            crossfade(2500)
            transformations(CircleCropTransformation())
        }
        textViewLeaderName.text = navArgs.community.leader?.name
        imageViewCommunityBanner.load(navArgs.community.banner){
            crossfade(true)
            crossfade(1000)

        }
        textViewCommunıtyName.text = navArgs.community.name
        imageButtonLinksInstagram.setOnClickListener{
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(navArgs.community.links?.instagram)
                )
            )
        }
        imageButtonLinksTwitter.setOnClickListener{
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(navArgs.community.links?.twitter)
                )
            )
        }
        imageButtonLinksApply.setOnClickListener{
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(navArgs.community.links?.participation)
                )
            )
        }
        imageButtonLinksYoutube.setOnClickListener{
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(navArgs.community.links?.youtube)
                )
            )
        }


    }


}