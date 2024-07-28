package com.week6.dialogtest

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.week6.dialogtest.databinding.ActivityMainBinding
import com.week6.dialogtest.databinding.DialogLayoutBinding

class MainActivity : AppCompatActivity() {

    val mainBinding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    var selectedIdx = 0
    var selectedItems = booleanArrayOf(false, false, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

        mainBinding.button.setOnClickListener {
            val dialogBinding = DialogLayoutBinding.inflate(layoutInflater)

            val onOnClick = object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, which: Int) {
                    Toast.makeText(this@MainActivity, "확인!", Toast.LENGTH_SHORT).show()
                }
            }

            val builder : AlertDialog.Builder = AlertDialog.Builder(this).apply {
                setTitle("대화상자 제목")
                setView(dialogBinding.root)

                //setItems(R.array.foods) {
                //    dialogInterface: DialogInterface?, idx: Int
                //    ->
                //    val foods = resources.getStringArray(R.array.foods)
                //   Toast.makeText(this@MainActivity, "선택:" + foods[idx], Toast.LENGTH_SHORT).show()
                //    Log.d("MainActivity", "${foods[idx]}")
                //}
                //setSingleChoiceItems(R.array.foods, selectedIdx) {
                //    dialogInterface: DialogInterface?, idx: Int
                //        ->
                //    selectedIdx = idx
                //    Toast.makeText(this@MainActivity, "선택:" + foods[idx], Toast.LENGTH_SHORT).show()
                //}
                //setMultiChoiceItems(R.array.foods, selectedItems) {
                //    dialogInterface: DialogInterface?, idx: Int, isChecked: Boolean ->
                //    selectedItems[idx] = isChecked
                //}
                setMessage("대화상자 메시지")
                setIcon(R.mipmap.ic_launcher)
                setPositiveButton("확인") {
                    //p0: DialogInterface?, idx: Int ->
                    //val foods = resources.getStringArray(R.array.foods)
                    //Toast.makeText(this@MainActivity, "선택: ${foods[selectedIdx]}", Toast.LENGTH_SHORT).show()
                    dialogInterface: DialogInterface?, which: Int ->
                    Log.d("MainActivity", "${dialogBinding.etText.text}")
                }
                setNeutralButton("대기", null)
                setNegativeButton("취소", {p0: DialogInterface?, which: Int
                    -> Toast.makeText(this@MainActivity, "취소!", Toast.LENGTH_SHORT).show() })
                setCancelable(false)
            }
            // val dialog: Dialog = builder.create()
            // dialog.show()
            builder.show()
            Toast.makeText(this, "게속 수행!", Toast.LENGTH_SHORT).show()
        }
    }
}