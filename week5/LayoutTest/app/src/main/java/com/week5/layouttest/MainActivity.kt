package com.week5.layouttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.week5.layouttest.databinding.LinearLayerBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : LinearLayerBinding =
            LinearLayerBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.button1.setOnClickListener {
            val layout : LinearLayout = findViewById(R.id.linear)
            layout.orientation = LinearLayout.VERTICAL
        }
        binding.button2.setOnClickListener {
            val layout : LinearLayout = findViewById(R.id.linear)
            layout.orientation = LinearLayout.HORIZONTAL
        }
    }

}