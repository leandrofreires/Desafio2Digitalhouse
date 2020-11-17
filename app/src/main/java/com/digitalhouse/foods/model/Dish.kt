package com.digitalhouse.foods.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//Dish é o prato
@Parcelize
class Dish(
    var name: String,
    var description: String,
    var picture: String
) :Parcelable