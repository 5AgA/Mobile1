package com.week4.practice01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun onClickHello(view: View) {
        val name = findViewById<EditText>(R.id.etName).text
        val phone = findViewById<EditText>(R.id.etPhone).text
        val str = "안녕하세요, 저는 $name 입니다." + "전화번호는 $phone 입니다."
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }

    fun onClickExit(view: View) {
        finish()
    }
}