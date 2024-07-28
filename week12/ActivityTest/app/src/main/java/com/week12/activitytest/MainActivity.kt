package com.week12.activitytest

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.week12.activitytest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    val TAG = "MainActivity"

    val DETAIL_ACTIVITY_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
//            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-1234-5678")) 전화번호 전달
//            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com")) url 전달
            val intent = Intent(this, DetailActivity::class.java)
//            intent.putExtra("subject", "mobile software")
            val dto = FoodDto(R.mipmap.ic_launcher, "치킨", 10)
            intent.putExtra("food", dto)
//            startActivity(intent)
            startActivityForResult(intent, DETAIL_ACTIVITY_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // requestCode: DETAIL_ACTIVITY_CODE     resultCode: RESULT_OK, RESULT_CANCELED

        if (requestCode == DETAIL_ACTIVITY_CODE) {
            when(resultCode) {
                RESULT_OK -> {
                    val result = data?.getStringExtra("result_data")
                    Log.d(TAG, result!!)
                }

                RESULT_CANCELED -> {

                }
            }
        }
    }
}