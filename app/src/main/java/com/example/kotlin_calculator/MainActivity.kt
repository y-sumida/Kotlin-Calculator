package com.example.kotlin_calculator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculate.setOnClickListener {
            var isValid = true

            val priceText = price.text.toString()
            if (priceText.isEmpty()) {
                price.error = getString(R.string.price_error)
                isValid = false
            }

            val discountText = discount.text.toString()
            if (discountText.isEmpty()) {
                discount.error = getString(R.string.discount_error)
                isValid = false
            }

            if (isValid) {
                val price = Integer.parseInt(priceText)
                val discount = Integer.parseInt(discountText)

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("price", price)
                intent.putExtra("discount", discount)
                startActivity(intent)
            }
        }
    }
}
