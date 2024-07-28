package com.example.week10.recyclerviewtest

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week10.recyclerviewtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    val dao = SubjectDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 원본 데이터 준비
        val dataList = dao.dataList

        val layoutManager  = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recyclerView.layoutManager = layoutManager

        val adapter = MyAdapter(this, R.layout.list_item, dataList)
        binding.recyclerView.adapter = adapter

        binding.button.setOnClickListener {
            dataList.add(binding.editText.toString())
            adapter.notifyDataSetChanged()
        }
    }
}