package com.digitalhouse.foods.view.restaurants

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.foods.R
import com.digitalhouse.foods.model.Restaurant
import com.digitalhouse.foods.view.dishes.DishActivity
import com.digitalhouse.foods.view.dishes.DishesRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_restaurant.*

class RestaurantActivity : AppCompatActivity() {
    private var restautant: Restaurant? = null
    private  val recyclerView: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.dishes_container)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)
        restautant = intent.getParcelableExtra("restaurantData")
        restautant?.let {
            val context = restaurant_photo.getContext()
            val id: Int = context.getResources()
                .getIdentifier(restautant?.picture, "drawable", context.getPackageName())
            restaurant_photo.setImageResource(id)
            restaurant_title.text = it.name
            recyclerView.apply {
                layoutManager = GridLayoutManager(this@RestaurantActivity, 2)
                adapter = DishesRecyclerViewAdapter(it.dish){ position ->
                    val intent = Intent(this@RestaurantActivity, DishActivity::class.java)
                    intent.putExtra("dishData", it.dish[position])
                    startActivity(intent)
                }
            }
        }

        restaurant_back_button.setOnClickListener {
            finish()
        }

    }
}