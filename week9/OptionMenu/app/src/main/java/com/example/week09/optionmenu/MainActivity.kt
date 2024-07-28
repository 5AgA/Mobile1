package com.example.week09.optionmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.week09.optionmenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.subitem01_1 -> {
                Toast.makeText(this, "짜장면", Toast.LENGTH_SHORT).show()
            }
            R.id.subitem01_2 -> {
                Toast.makeText(this, "짬뽕", Toast.LENGTH_SHORT).show()
            }
            R.id.subitem02_1 -> {
                Toast.makeText(this, "김치찜", Toast.LENGTH_SHORT).show()
            }
            R.id.subitem02_2 -> {
                Toast.makeText(this, "제육볶음", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }
}