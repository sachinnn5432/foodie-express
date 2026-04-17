package com.example.foodordering

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodordering.databinding.ItemCartBinding

class CartAdapter(
    private val cartItems: MutableList<CartItem>,
    private val onUpdate: () -> Unit
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    class CartViewHolder(val binding: ItemCartBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = cartItems[position]
        holder.binding.tvCartFoodName.text = item.foodItem.name
        holder.binding.tvCartFoodPrice.text = "₹${String.format("%.2f", item.foodItem.price * item.quantity)}"
        holder.binding.tvQuantity.text = item.quantity.toString()

        Glide.with(holder.itemView.context)
            .load(item.foodItem.imageUrl)
            .centerCrop()
            .placeholder(android.R.drawable.ic_menu_gallery)
            .into(holder.binding.ivCartFood)

        holder.binding.btnRemove.setOnClickListener {
            if (item.quantity > 1) {
                item.quantity--
                notifyItemChanged(position)
            } else {
                cartItems.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position, cartItems.size)
            }
            onUpdate()
        }
    }

    override fun getItemCount() = cartItems.size
}
