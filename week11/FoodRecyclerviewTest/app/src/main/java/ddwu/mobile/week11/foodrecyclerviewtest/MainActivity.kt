package ddwu.mobile.week11.foodrecyclerviewtest

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import ddwu.mobile.week11.foodrecyclerviewtest.databinding.ActivityMainBinding
import ddwu.mobile.week11.foodrecyclerviewtest.databinding.ListItemBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val foods = FoodDao().foods
        val adapter = FoodAdapter(foods)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter

        val listener = object : FoodAdapter.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                Toast.makeText(this@MainActivity,
                    "${foods[position]}", Toast.LENGTH_SHORT).show()
            }
        }
        adapter.setOnItemClickListener( listener )

        val listener2 = object : FoodAdapter.OnItemLongClickListener {
            override fun onItemLongClick(view: View, position: Int): Boolean {
                val builder = AlertDialog.Builder(this@MainActivity).apply {
                    title = "알림"
                    setMessage("삭제하시겠습니까?")
                    setPositiveButton("확인") {
                        dialogInterface: DialogInterface?, i: Int ->
                        foods.removeAt(position)
                        adapter.notifyDataSetChanged()
                    }
                    setNegativeButton("취소", null)
                }
                builder.show()
                return true
            }
        }
        adapter.setOnItemLongClickListener(listener2)
    }
}