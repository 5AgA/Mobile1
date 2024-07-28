package ddwu.com.mobile.fooddbexam

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ddwu.com.mobile.fooddbexam.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {

    val addBinding by lazy {
        ActivityAddBinding.inflate(layoutInflater)
    }

    lateinit var helper : FoodDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(addBinding.root)

        helper = FoodDBHelper(this@AddActivity)

        addBinding.btnAddFood.setOnClickListener {
            val food = addBinding.etAddFood.text.toString()
            val country = addBinding.etAddNation.text.toString()
            addFood(food, country)
        }
    }

    fun addFood(food: String, country: String) {
        val db = helper.writableDatabase
        val newRow = ContentValues()
        newRow.put("food", food)
        newRow.put("country", country)
        db.insert("food_table", null, newRow)
        helper.close()
        finish()
    }
}