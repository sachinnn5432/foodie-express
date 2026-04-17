package com.example.foodordering

import android.app.Activity
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import com.example.foodordering.databinding.LayoutCustomToastBinding

fun Activity.showCustomToast(message: String) {
    val binding = LayoutCustomToastBinding.inflate(LayoutInflater.from(this))
    binding.tvToastMessage.text = message
    
    val toast = Toast(this)
    toast.duration = Toast.LENGTH_SHORT
    toast.view = binding.root
    toast.setGravity(Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, 0, 100)
    toast.show()
}
