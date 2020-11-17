package com.digitalhouse.foods.view.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.digitalhouse.foods.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Register")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        this.finish();
        return super.onOptionsItemSelected(item)
    }
}