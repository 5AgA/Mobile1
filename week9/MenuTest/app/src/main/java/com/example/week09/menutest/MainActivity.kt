package com.example.week09.menutest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.week09.menutest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    var selected = 0
    var contextSelected = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        registerForContextMenu(binding.tvText)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?, //
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        when(v?.id) {
            R.id.tvText -> {
                menuInflater.inflate(R.menu.menu_main, menu)
            }
        }

        when(contextSelected) {
            0 -> {
                menu?.findItem(R.id.subitem01)?.setChecked(true)
            }
            1 -> {
                menu?.findItem(R.id.subitem02)?.setChecked(true)
            }
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.subitem01 -> {
                Toast.makeText(this, "Context01", Toast.LENGTH_SHORT).show()
                contextSelected = 0
            }
            R.id.subitem02 -> {
                Toast.makeText(this, "Context02", Toast.LENGTH_SHORT).show()
                contextSelected = 1
            }
        }
        return true
    }

    /********************************************************************************/
    // 메뉴 표시
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu) // 메뉴 파일을 매개변수 메인 변수에 넣어준다
        return super.onCreateOptionsMenu(menu)
    }

    // 체크 표시
    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        when(selected) {
            0 -> {
                menu?.findItem(R.id.subitem01)?.setChecked(true)
            }
            1 -> {
                menu?.findItem(R.id.subitem02)?.setChecked(true)
            }
        }
        return super.onPrepareOptionsMenu(menu)
    }

    // 눌렀을 때 동작
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.subitem01 -> {
                Toast.makeText(this, "01", Toast.LENGTH_SHORT).show()
                selected = 0
            }
            R.id.subitem02 -> {
                Toast.makeText(this, "02", Toast.LENGTH_SHORT).show()
                selected = 1
            }
        }

        return true
    }

    fun onMenuClick(item: MenuItem) {
        Toast.makeText(this,"Item", Toast.LENGTH_SHORT).show()
    }
}