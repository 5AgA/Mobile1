package ddwu.com.mobile.week06.sample.mycustomview

import android.graphics.Color
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ddwu.com.mobile.week06.sample.mycustomview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val mainBinding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

        val myTouch = object: View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                mainBinding.myCustomView.posX = event!!.x
                mainBinding.myCustomView.posY = event!!.y
                mainBinding.myCustomView.invalidate()
                return false
            }
        }

        val myLongTouch = object: View.OnLongClickListener {
            override fun onLongClick(v: View?): Boolean {
                var pColor = mainBinding.myCustomView.paintColor
                if (pColor == Color.RED)
                    mainBinding.myCustomView.paintColor = Color.BLUE
                else
                    mainBinding.myCustomView.paintColor = Color.RED
                mainBinding.myCustomView.invalidate()
                return false
            }
        }

        mainBinding.myCustomView.setOnTouchListener(myTouch)
        mainBinding.myCustomView.setOnLongClickListener(myLongTouch)
    }
}

