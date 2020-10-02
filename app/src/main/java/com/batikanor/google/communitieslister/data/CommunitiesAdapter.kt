package com.batikanor.google.communitieslister.data


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.batikanor.google.communitieslister.R
import com.batikanor.google.communitieslister.data.model.Community
import kotlinx.android.synthetic.main.item_community.view.*


class CommunitiesAdapter(
    private val communityList: MutableList<Community>,
    private val onClick: (Community) -> Unit
) :
    RecyclerView.Adapter<CommunityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommunityViewHolder {
        return CommunityViewHolder(parent.inflate(R.layout.item_community))
    }

    override fun onBindViewHolder(holder: CommunityViewHolder, position: Int) {
        val comm = communityList[position]
        holder.bind(comm, onClick)
    }

    override fun getItemCount(): Int = communityList.size
}

class CommunityViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(community: Community, onClick: (Community) -> Unit) {
        itemView.imageViewBanner.load(community.banner){
            //crossfade(true)
            //transformations(CircleCropTransformation())
        }

        itemView.setOnClickListener {
            onClick(community)
        }
    }
}

fun ViewGroup.inflate(layoutId: Int): View {
    val layoutInflater = LayoutInflater.from(context)
    return layoutInflater.inflate(layoutId, this, false)
}