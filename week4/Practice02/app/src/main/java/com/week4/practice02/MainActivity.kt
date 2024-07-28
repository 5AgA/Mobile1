package com.week4.practice02

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.week4.practice02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val viewBinding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        var edtext : EditText = viewBinding.editText

        viewBinding.buttonOne.setOnClickListener() {
            edtext.setText(edtext.text.toString() + "1")
        }
        viewBinding.buttonTwo.setOnClickListener() {
            edtext.setText(edtext.text.toString() + "2")
        }
        viewBinding.buttonThree.setOnClickListener() {
            edtext.setText(edtext.text.toString() + "3")
        }
        viewBinding.buttonClear.setOnClickListener() {
            edtext.setText("")
        }
    }
}