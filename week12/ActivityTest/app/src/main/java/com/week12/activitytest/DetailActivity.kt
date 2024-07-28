package com.week12.activitytest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.week12.activitytest.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    val detailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    val TAG = "DetailActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(detailBinding.root)

//        val data = intent.getStringExtra("subject")
//        Log.d(TAG, "subject: ${data}")
        val food = intent.getSerializableExtra("food")
        Log.d(TAG, "food: ${food}")

        detailBinding.btnDetail.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("result_data", "DetailActivity returns data!")
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}