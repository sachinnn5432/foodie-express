package com.example.foodordering

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodordering.databinding.ActivityCartBinding

class CartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Your Cart"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener { finish() }

        updateTotal()

        binding.rvCart.layoutManager = LinearLayoutManager(this)
        binding.rvCart.adapter = CartAdapter(DataProvider.cartItems) {
            updateTotal()
        }

        binding.btnCheckout.setOnClickListener {
            if (DataProvider.cartItems.isNotEmpty()) {
                startActivity(Intent(this, CheckoutActivity::class.java))
            } else {
                Toast.makeText(this, "Cart is empty", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun updateTotal() {
        val total = DataProvider.cartItems.sumOf { it.foodItem.price * it.quantity }
        binding.tvTotal.text = getString(R.string.total_price, total)
    }
}
