package com.example.foodordering

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodordering.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val restaurant = intent.getSerializableExtra("restaurant") as? Restaurant
        
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = restaurant?.name ?: "Menu"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener { 
            finish()
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }

        val filteredMenu = DataProvider.foodItems.filter { it.restaurantId == restaurant?.id }

        binding.rvFoodItems.layoutManager = LinearLayoutManager(this)
        binding.rvFoodItems.adapter = FoodAdapter(filteredMenu)

        binding.btnViewCart.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }
    
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
    }
}
