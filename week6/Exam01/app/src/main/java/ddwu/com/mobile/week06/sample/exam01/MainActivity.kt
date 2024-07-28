package ddwu.com.mobile.week06.sample.exam01

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ddwu.com.mobile.week06.sample.exam01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val mainBinding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)
        // 3. SAM 적용
        mainBinding.btnOutput.setOnClickListener {
            mainBinding.tvDisplay.text = mainBinding.etInput.text
        }
    }
}

// 1. 별도의 리스너 인터페이스 구현 클래스
/*
class MainActivity : AppCompatActivity() {
    val mainBinding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

        val myClick = MyClick(this, mainBinding)
        mainBinding.btnOutput.setOnClickListener(myClick)
    }

    class MyClick(val context: Context, val mainBinding: ActivityMainBinding) : View.OnClickListener {
        override fun onClick(v: View?) {
            mainBinding.tvDisplay.text = mainBinding.etInput.text
        }

    }
}
 */

// 2. 익명 객체 구현
/*
class MainActivity : AppCompatActivity() {
    val mainBinding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

        val myClick = object: View.OnClickListener {
            override fun onClick(v: View?) {
                mainBinding.tvDisplay.text = mainBinding.etInput.text
            }
        }
        mainBinding.btnOutput.setOnClickListener(myClick)
    }
}
 */