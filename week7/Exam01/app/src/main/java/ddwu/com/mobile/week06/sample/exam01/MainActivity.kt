package ddwu.com.mobile.week06.sample.exam01

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ddwu.com.mobile.week06.sample.exam01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /*viewBinding 관련 부분 작성할 것*/
    val mainBinding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

        mainBinding.btnOutput.setOnClickListener {
            val builder : AlertDialog.Builder = AlertDialog.Builder(this).apply {
                setTitle("입력 확인")
                setMessage("${mainBinding.etInput.text} 를 입력하시겠습니까?")
                setPositiveButton("네") {
                    dlgInterface: DialogInterface?, which : Int ->
                    mainBinding.tvDisplay.text = mainBinding.etInput.text
                }
                setNegativeButton("아니오", null)
            }
            builder.show()
        }
    }
}