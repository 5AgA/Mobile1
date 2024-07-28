package ddwu.com.mobile.week06.sample.mycustomview

import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ddwu.com.mobile.week06.sample.mycustomview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    var selected = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        registerForContextMenu(binding.myCustomView)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.bigger -> {
                binding.myCustomView.posR += 50f
                binding.myCustomView.invalidate()
            }
            R.id.smaller -> {
                binding.myCustomView.posR -= 50f
                binding.myCustomView.invalidate()
            }
        }
        return true
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        menuInflater.inflate(R.menu.context_menu, menu)

        when(selected) {
            0 -> {
                menu?.findItem(R.id.red)?.setChecked(true)
            }
            1 -> {
                menu?.findItem(R.id.green)?.setChecked(true)
            }
            2 -> {
                menu?.findItem(R.id.blue)?.setChecked(true)
            }
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.red -> {
                selected = 0
                binding.myCustomView.paintColor = Color.RED
                binding.myCustomView.invalidate()
            }
            R.id.green -> {
                selected = 1
                binding.myCustomView.paintColor = Color.GREEN
                binding.myCustomView.invalidate()
            }
            R.id.blue -> {
                selected = 2
                binding.myCustomView.paintColor = Color.BLUE
                binding.myCustomView.invalidate()
            }
        }
        return true
    }
}