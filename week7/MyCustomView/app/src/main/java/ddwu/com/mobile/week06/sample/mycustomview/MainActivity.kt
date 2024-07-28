package ddwu.com.mobile.week06.sample.mycustomview

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import ddwu.com.mobile.week06.sample.mycustomview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val mainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

        mainBinding.myCustomView.setOnLongClickListener {
            val dialogLayout = DialogLayoutBinding.inflate(layoutInflater)

            val builder = AlertDialog.Builder(this).apply {
                
            }

            true
        }
    }
}