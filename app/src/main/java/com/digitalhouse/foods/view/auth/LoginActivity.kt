package com.digitalhouse.foods.view.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.digitalhouse.foods.R
import com.digitalhouse.foods.view.restaurants.RestaurantsActivity
import com.google.android.material.button.MaterialButton

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val buttonRegister = findViewById<MaterialButton>(R.id.button_register)
        val buttonLoggin = findViewById<MaterialButton>(R.id.button_login)
        buttonRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        buttonLoggin.setOnClickListener {
            startActivity(Intent(this, RestaurantsActivity::class.java))
        }
    }
}