package com.week5.myviewtest

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.week5.myviewtest.databinding.ActivityMainBinding
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        //val myView = MyOuterView(this) // this = MainActivity, context 라는 클래스를 상속받음
        setContentView(binding.root)

        binding.button.setOnClickListener {
            binding.myOuterView.color = Color.RED
            binding.myOuterView.invalidate()
        }

        binding.button2.setOnClickListener {
            val random = Random()
            binding.myOuterView.newX = random.nextInt(500).toFloat()
            binding.myOuterView.newY = random.nextInt(500).toFloat()
            binding.myOuterView.newR = ((random.nextInt(2) + 1) * 100).toFloat()
            binding.myOuterView.invalidate()
        }
    }

    /*class MyView constructor(context: Context?) : View(context) {
        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)
            canvas?.drawColor(Color.LTGRAY)
            val paint = Paint()
            paint.setColor(Color.BLUE)
            canvas?.drawCircle(200.toFloat(), 200.toFloat(), 100.toFloat(), paint)
        }
    }*/
}