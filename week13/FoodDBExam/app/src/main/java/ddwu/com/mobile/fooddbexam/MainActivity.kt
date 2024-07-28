package ddwu.com.mobile.fooddbexam

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ddwu.com.mobile.fooddbexam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//    val TAG = "MainActivity"
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    lateinit var helper : FoodDBHelper

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        helper = FoodDBHelper(this)

        binding.btnSelect.setOnClickListener{
            val foodList = showFoods()
            var data = ""
            for (food in foodList){
                data += food.toString() + "\n"
            }
            binding.textView2.text = data
        }

        binding.btnAdd.setOnClickListener{
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }

        binding.btnUpdate.setOnClickListener{
            val intent = Intent(this, UpdateActivity::class.java)
            startActivity(intent)
        }

        binding.btnRemove.setOnClickListener{
            val intent = Intent(this, RemoveActivity::class.java)
            startActivity(intent)
        }

    }

    @SuppressLint("Range")
    fun showFoods(): List<FoodDto> {
        val db = helper.readableDatabase
        val columns = null
        val cursor = db.query(
            "food_table", columns, null, null,
            null, null, null, null
        )

        val foodList = arrayListOf<FoodDto>()
        with(cursor) {
            while(moveToNext()) {
                val id = getInt(0)
                val food = getString(1)
                val country = getString(getColumnIndex("country"))
                val dto = FoodDto(id, food, country)
                foodList.add(dto)
            }
        }

        cursor.close()
        helper.close()
        return foodList
    }

}