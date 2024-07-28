package ddwu.com.mobile.fooddbexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ddwu.com.mobile.fooddbexam.databinding.ActivityRemoveBinding

class RemoveActivity : AppCompatActivity() {

    val removeBinding by lazy {
        ActivityRemoveBinding.inflate(layoutInflater)
    }

    lateinit var helper : FoodDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(removeBinding.root)

        helper = FoodDBHelper(this)

        removeBinding.btnRemoveFood.setOnClickListener {
            val food = removeBinding.etRemoveFood.text.toString()
            deleteFood(food)
        }
    }

    fun deleteFood(food: String) {
        val db = helper.writableDatabase
        val whereClause = "food=?"
        val whereArgs = arrayOf(food)
        db.delete("food_table", whereClause, whereArgs)
        helper.close()
        finish()
    }
}