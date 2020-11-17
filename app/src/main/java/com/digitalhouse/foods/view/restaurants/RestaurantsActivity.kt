package com.digitalhouse.foods.view.restaurants

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.foods.R
import com.digitalhouse.foods.model.restaurantsData
import com.digitalhouse.foods.view_model.RestaurantViewModel

class RestaurantsActivity : AppCompatActivity() {
    private lateinit  var restaurantViewModel: RestaurantViewModel
    private  val recyclerView: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.restaurants_recycler_view)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurants)

        restaurantViewModel = ViewModelProvider(this).get(RestaurantViewModel::class.java)
        restaurantViewModel.getRestaurants()

        restaurantViewModel.restaurantsLiveData.observe(this@RestaurantsActivity) {
            it?.let { restaurant ->
                recyclerView.apply {
                    // use a linear layout manager
                    layoutManager = LinearLayoutManager(this@RestaurantsActivity)
                    // specify an viewAdapter (see also next example)
                    adapter = RestaurantRecyclerViewAdapter(restaurant) { position ->
                        val intent = Intent(this@RestaurantsActivity, RestaurantActivity::class.java)
                        intent.putExtra("restaurantData", restaurant[position])
                        startActivity(intent)
                    }
                }
            }
        }


    }
}