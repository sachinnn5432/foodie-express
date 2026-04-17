package com.example.foodordering

import java.io.Serializable

data class Restaurant(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val rating: Float,
    val deliveryTime: String,
    val cuisines: String
) : Serializable

data class FoodItem(
    val id: Int,
    val restaurantId: Int,
    val name: String,
    val price: Double,
    val imageUrl: String,
    val rating: Float,
    val description: String
) : Serializable

data class CartItem(
    val foodItem: FoodItem,
    var quantity: Int
)
