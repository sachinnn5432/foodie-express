package com.example.foodordering

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.foodordering.databinding.ActivityCheckoutBinding
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import org.json.JSONObject

class CheckoutActivity : AppCompatActivity(), PaymentResultListener {
    private lateinit var binding: ActivityCheckoutBinding
    private val razorpayKeyId = "rzp_test_SeexT7isLxMrg5"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Checkout.preload(applicationContext)

        val total = DataProvider.cartItems.sumOf { it.foodItem.price * it.quantity }
        binding.tvOrderSummary.text = getString(R.string.total_price, total)

        binding.btnConfirmOrder.setOnClickListener {
            val address = binding.etAddress.text.toString()
            if (address.isEmpty()) {
                showToast("Please enter delivery address")
                return@setOnClickListener
            }

            if (binding.rbOnline.isChecked) {
                startPayment(total)
            } else {
                showConfirmationDialog()
            }
        }
    }

    private fun startPayment(amount: Double) {
        val checkout = Checkout()
        checkout.setKeyID(razorpayKeyId)

        try {
            val options = JSONObject()
            options.put("name", "Foodie Express")
            options.put("description", "Food Order Payment")
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png")
            options.put("theme.color", "#FF6B00")
            options.put("currency", "INR")
            options.put("amount", (amount * 100).toLong()) // Amount in paise

            val retryObj = JSONObject()
            retryObj.put("enabled", true)
            retryObj.put("max_count", 4)
            options.put("retry", retryObj)

            val prefill = JSONObject()
            prefill.put("email", "customer@example.com")
            prefill.put("contact", "9876543210")
            options.put("prefill", prefill)

            checkout.open(this, options)
        } catch (e: Exception) {
            showToast("Error in payment: " + e.message)
            e.printStackTrace()
        }
    }

    override fun onPaymentSuccess(razorpayPaymentId: String?) {
        showToast("Payment Successful: $razorpayPaymentId")
        showConfirmationDialog()
    }

    override fun onPaymentError(code: Int, response: String?) {
        showToast("Payment Failed: $response")
    }

    private fun showConfirmationDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Order Confirmed")
        builder.setMessage("Your order has been placed successfully!")
        builder.setPositiveButton("Track Order") { _, _ ->
            DataProvider.cartItems.clear()
            val intent = Intent(this, OrderTrackingActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }
        builder.setCancelable(false)
        builder.show()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
