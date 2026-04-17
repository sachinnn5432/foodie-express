package com.example.foodordering

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodordering.databinding.ItemRestaurantBinding

class RestaurantAdapter(
    private val restaurants: List<Restaurant>,
    private val onItemClick: (Restaurant) -> Unit
) : RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    class RestaurantViewHolder(val binding: ItemRestaurantBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val binding = ItemRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val restaurant = restaurants[position]
        holder.binding.tvRestaurantName.text = restaurant.name
        holder.binding.tvRating.text = "${restaurant.rating} ★"
        holder.binding.tvDeliveryTime.text = restaurant.deliveryTime
        holder.binding.tvCuisines.text = restaurant.cuisines
        
        Glide.with(holder.itemView.context)
            .load(restaurant.imageUrl)
            .centerCrop()
            .placeholder(android.R.drawable.ic_menu_gallery)
            .into(holder.binding.ivRestaurant)

        holder.itemView.setOnClickListener { 
            it.animate().scaleX(0.95f).scaleY(0.95f).setDuration(100).withEndAction {
                it.animate().scaleX(1f).scaleY(1f).setDuration(100).withEndAction {
                    onItemClick(restaurant)
                }
            }
        }
    }

    override fun getItemCount() = restaurants.size
}
