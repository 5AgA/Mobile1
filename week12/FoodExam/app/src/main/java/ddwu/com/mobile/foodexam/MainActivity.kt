package ddwu.com.mobile.foodexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import ddwu.com.mobile.foodexam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    val ADD_FOOD_ACTIVITY_CODE = 100
    private lateinit var adapter: FoodAdapter
    private val foods = FoodDao().foods

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        adapter = FoodAdapter(foods)

        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter

        // btnAdd를 클릭하면 AddFoodActivity 실행
        binding.btnAdd.setOnClickListener {
            val intent = Intent(this, AddFoodActivity::class.java)
            startActivityForResult(intent, ADD_FOOD_ACTIVITY_CODE)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == ADD_FOOD_ACTIVITY_CODE) {
            when(resultCode) {
                RESULT_OK -> {
                    val newFoodDto = data?.getSerializableExtra("foodDto")

                    foods.add(newFoodDto as FoodDto)
                    adapter.notifyDataSetChanged()
                }
                RESULT_CANCELED -> {

                }
            }
        }
    }
}