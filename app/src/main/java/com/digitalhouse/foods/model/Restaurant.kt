package com.digitalhouse.foods.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Restaurant(
    var name: String,
    var local_address: String,
    var closed_hours: String,
    var dish: MutableList<Dish>,
    var picture: String
): Parcelable