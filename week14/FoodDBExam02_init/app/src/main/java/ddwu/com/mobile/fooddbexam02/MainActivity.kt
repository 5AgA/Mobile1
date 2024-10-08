package ddwu.com.mobile.fooddbexam02

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import ddwu.com.mobile.fooddbexam02.data.FoodDao
import ddwu.com.mobile.fooddbexam02.data.FoodDto
import ddwu.com.mobile.fooddbexam02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    val REQ_ADD = 100
    val REQ_UPDATE = 200

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    val foodDao by lazy {
        FoodDao(this)
    }

    lateinit var foods : ArrayList<FoodDto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        /*RecyclerView 의 layoutManager 지정*/
        binding.rvFoods.layoutManager = LinearLayoutManager(this).apply {
            orientation = LinearLayoutManager.VERTICAL
        }

        foods = foodDao.getAllFoods()               // DB 에서 모든 food를 가져옴
        val adapter = FoodAdapter(foods)        // adapter 에 데이터 설정
        binding.rvFoods.adapter = adapter   // RecylcerView 에 adapter 설정

        binding.btnAdd.setOnClickListener {
            val intent = Intent(this@MainActivity, AddActivity::class.java)
            startActivityForResult(intent, REQ_ADD)      // 수정결과를 받아오도록 Activity 호출
        }

        adapter.setOnItemClickListener(object : FoodAdapter.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                val intent = Intent(this@MainActivity, UpdateActivity::class.java)
                intent.putExtra("dto", foods.get(position) )   // 클릭한 RecyclerView 항목 위치의 dto 전달
                startActivityForResult(intent, REQ_UPDATE)      // 수정결과를 받아오도록 Activity 호출
            }
        })

        adapter.setOnItemLongClickListener(object : FoodAdapter.OnItemLongClickListener {
            override fun onItemLongClick(view: View, position: Int): Boolean {
                // 현재 항목의 DB 삭제
                notifyDB(foodDao.deleteFood(foods[position]), false)
                return true
            }
        })
    }

//    override fun onResume() {
//        super.onResume()
//        binding.rvFoods.adapter?.notifyDataSetChanged()   // 액티비티가 보일 때마다 RecyclerView 를 갱신하고자 할 경우
//    }

    @SuppressLint("NotifyDataSetChanged")
    fun notifyDB(result: Int, isReq: Boolean) {
        if (isReq) {
            if (result == RESULT_OK) {
                foods.clear()                       // 기존 항목 제거
                foods.addAll(foodDao.getAllFoods())         // 항목 추가
                binding.rvFoods.adapter?.notifyDataSetChanged()      // RecyclerView 갱신
            } else {
                Toast.makeText(this@MainActivity, "취소됨", Toast.LENGTH_SHORT).show()
            }
        } else {
            if (result > 0) {
                foods.clear()                       // 기존 항목 제거
                foods.addAll(foodDao.getAllFoods())         // 항목 추가
                binding.rvFoods.adapter?.notifyDataSetChanged()      // RecyclerView 갱신
            } else {
                Toast.makeText(this@MainActivity, "취소됨", Toast.LENGTH_SHORT).show()
            }
        }

    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQ_UPDATE,REQ_ADD -> {
                notifyDB(resultCode, true)
            }
        }
    }

}