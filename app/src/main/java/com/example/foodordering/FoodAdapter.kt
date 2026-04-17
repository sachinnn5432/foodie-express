package com.example.foodordering

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodordering.databinding.ItemFoodBinding

class FoodAdapter(
    private val foodItems: List<FoodItem>
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    class FoodViewHolder(val binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val item = foodItems[position]
        holder.binding.tvFoodName.text = item.name
        holder.binding.tvFoodPrice.text = "₹${String.format("%.2f", item.price)}"
        holder.binding.tvFoodDesc.text = item.description

        Glide.with(holder.itemView.context)
            .load(item.imageUrl)
            .centerCrop()
            .placeholder(android.R.drawable.ic_menu_gallery)
            .into(holder.binding.ivFood)

        holder.binding.btnAddToCart.setOnClickListener {
            // Click animation
            it.animate().scaleX(0.9f).scaleY(0.9f).setDuration(100).withEndAction {
                it.animate().scaleX(1f).scaleY(1f).setDuration(100)
            }

            val existingItem = DataProvider.cartItems.find { it.foodItem.id == item.id }
            if (existingItem != null) {
                existingItem.quantity++
            } else {
                DataProvider.cartItems.add(CartItem(item, 1))
            }
            Toast.makeText(holder.itemView.context, "${item.name} added to cart", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount() = foodItems.size
}
