package com.digitalhouse.foods.view.dishes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.digitalhouse.foods.R
import com.digitalhouse.foods.model.Dish
import kotlinx.android.synthetic.main.activity_dish.*

class DishActivity : AppCompatActivity() {
    private var dish: Dish? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish)
        dish = intent.getParcelableExtra("dishData")
        dish?.let {
            val context = dish_photo.getContext()
            val id: Int = context.getResources()
                .getIdentifier(dish?.picture, "drawable", context.getPackageName())
            dish_photo.setImageResource(id)
            dish_title.text = it.name
            dish_description.text = it.description
        }
        dish_back_button.setOnClickListener {
            finish()
        }
    }
}