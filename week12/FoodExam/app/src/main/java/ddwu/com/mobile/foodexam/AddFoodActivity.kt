package ddwu.com.mobile.foodexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ddwu.com.mobile.foodexam.databinding.ActivityAddFoodBinding

class AddFoodActivity : AppCompatActivity() {
    val TAG = "AddFoodActivity"

    val binding by lazy {
        ActivityAddFoodBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            val resultIntent = Intent()
            val newFood = binding.etNewFood.text.toString()
            val country = binding.etCountry.text.toString()
            val newFoodDto = FoodDto(newFood, country)

            resultIntent.putExtra("foodDto", newFoodDto)
            setResult(RESULT_OK, resultIntent)
            finish()
        }

        binding.btnCancel.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}