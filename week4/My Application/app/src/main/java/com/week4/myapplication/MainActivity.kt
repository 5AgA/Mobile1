package com.week4.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView : TextView = findViewById(R.id.myText)
        textView.setText("Hi!!!");
    }

    fun onMyClick (view : View) {
        Toast.makeText(this, "Click!", Toast.LENGTH_SHORT).show()

        val myEdit : EditText = findViewById(R.id.myEdit)
        val textView : TextView = findViewById(R.id.myText)
        textView.text = myEdit.text
    }
}