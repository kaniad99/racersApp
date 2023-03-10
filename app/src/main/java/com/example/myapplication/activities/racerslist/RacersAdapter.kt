package com.example.myapplication.activities.racerslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

data class RacersAdapter(
    private val mList: List<RacersViewModel>,
    private val onItemClicked: (RacersViewModel) -> Unit
) :
    RecyclerView.Adapter<RacersAdapter.ViewHolder>() {
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.racer_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val racerViewModel = mList[position]

        // sets the image to the textview1 from our itemHolder class
        holder.firstName.text = racerViewModel.racer.firstName

        // sets the text to the textview2 from our itemHolder class
        holder.lastName.text = racerViewModel.racer.lastName

        holder.itemView.setOnClickListener {
            onItemClicked(racerViewModel)
        }

    }


    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val firstName: TextView = itemView.findViewById(R.id.textView1)
        val lastName: TextView = itemView.findViewById(R.id.textView2)
    }
}