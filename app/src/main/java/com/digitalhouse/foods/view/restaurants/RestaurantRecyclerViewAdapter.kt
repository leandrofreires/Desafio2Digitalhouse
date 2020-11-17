package com.digitalhouse.foods.view.restaurants

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.foods.R
import com.digitalhouse.foods.model.Restaurant
import kotlinx.android.synthetic.main.restaurant_list_item.view.*

class RestaurantRecyclerViewAdapter(
    private val restaurantsData: MutableList<Restaurant>,
    private val onItemClicked: (Int) -> Unit
) : RecyclerView.Adapter<RestaurantRecyclerViewAdapter.MyViewHolder>() {
    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.restaurant_list_item, parent, false)
        return MyViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.bind(restaurantsData[position], onItemClicked)
    }
    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = restaurantsData.size
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(restaurant: Restaurant, onItemClicked: (Int) -> Unit) {
            val context = itemView.restaurant_photo.getContext()
            val id: Int = context.getResources()
                .getIdentifier(restaurant.picture, "drawable", context.getPackageName())
            itemView.restaurant_photo.setImageResource(id)
            itemView.restaurant_title.text = restaurant.name
            itemView.restaurant_address_as_subtitle.text = restaurant.local_address
            itemView.restaurant_close_hours.text = restaurant.closed_hours
            itemView.restaurant_item.setOnClickListener {
                onItemClicked(this@MyViewHolder.adapterPosition)
            }
        }
    }
}
