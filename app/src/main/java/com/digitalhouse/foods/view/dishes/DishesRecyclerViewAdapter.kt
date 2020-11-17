package com.digitalhouse.foods.view.dishes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.foods.R
import com.digitalhouse.foods.model.Dish
import kotlinx.android.synthetic.main.dishes_list_item.view.*

class DishesRecyclerViewAdapter(
    private val dishes: MutableList<Dish>,
    private val onItemClicked: (Int) -> Unit
) : RecyclerView.Adapter<DishesRecyclerViewAdapter.DishesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dishes_list_item, parent, false)
        return DishesViewHolder(view)
    }

    override fun onBindViewHolder(holder: DishesViewHolder, position: Int) {
        holder.bind(dishes[position], onItemClicked)
    }

    override fun getItemCount() = dishes.size

    class DishesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(dish: Dish, onItemClicked: (Int) -> Unit) {
            val context = itemView.restaurant_photo.getContext()
            val id: Int = context.getResources()
                .getIdentifier(dish.picture, "drawable", context.getPackageName())
            itemView.restaurant_photo.setImageResource(id)
            itemView.restaurant_title.text = dish.name
            itemView.dish_item.setOnClickListener {
                onItemClicked(this@DishesViewHolder.adapterPosition)
            }
        }
    }
}
