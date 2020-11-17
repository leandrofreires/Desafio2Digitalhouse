package com.digitalhouse.foods.view_model
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.digitalhouse.foods.model.Restaurant
import com.digitalhouse.foods.model.RestaurantModel

class RestaurantViewModel: ViewModel() {
    val restaurantsLiveData: MutableLiveData<MutableList<Restaurant>> = MutableLiveData()
    private val restaurantModel = RestaurantModel()

    fun getRestaurants() {
        restaurantsLiveData.postValue(restaurantModel.getRestaurants())
    }
}