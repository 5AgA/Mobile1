package com.week6.eventtest

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.week6.eventtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val mainBinding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)
        mainBinding.main.setOnClickListener {
            Toast.makeText(this@MainActivity, "롱클릭!!", Toast.LENGTH_SHORT).show()
        }
        mainBinding.button.setOnClickListener {  // 클래스 만드는 방법 생략
            Toast.makeText(this@MainActivity, "리스너 인터페이스 구성", Toast.LENGTH_SHORT).show()
        }
    }
}

//A : 다른 클래스에 인터페이스 객체 구현
/*class MainActivity : AppCompatActivity() {
    val mainBinding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)
        val myClick = MyClick(this)
        mainBinding.button.setOnClickListener(myClick)
    }
    class MyClick(val context: Context) : View.OnClickListener {
    override fun onClick(v: View?) {
        Toast.makeText(context, "리스너 인터페이스 구성", Toast.LENGTH_SHORT).show()
    }
}*/

//B : 메인 액티비티에 인터페이스 객체 구현
/*class MainActivity : AppCompatActivity(), View.OnClickListener {
    val mainBinding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)
        mainBinding.button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        Toast.makeText(this@MainActivity, "리스너 인터페이스 구성", Toast.LENGTH_SHORT).show()
    }
}*/

//C : 익명 액티비티에 인터페이스 객체 구현
/*class MainActivity : AppCompatActivity() {
    val mainBinding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

        mainBinding.button.setOnClickListener(myClick)
    }

    val myClick = object: View.OnClickListener {
        override fun onClick(v: View?) {
            Toast.makeText(this@MainActivity, "리스너 인터페이스 구성", Toast.LENGTH_SHORT).show()
        }
    }
}*/

// C-변형
/*mainBinding.button.setOnClickListener (object: View.OnClickListener {  // 클래스 만드는 방법 생략
            override fun onClick(v: View?) {
                Toast.makeText(this@MainActivity, "리스너 인터페이스 구성", Toast.LENGTH_SHORT).show()
            }
        })*/

