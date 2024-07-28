package com.example.week10.recyclerviewtest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val context: Context, val layout: Int, val list: ArrayList<String>)
    : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    // Recycler에 표시할 전체 뷰의 개수 == 원본 데이터의 개수
    override fun getItemCount(): Int {
        return list.size
    }

    // 각 항목의 뷰를 갖는 Holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(layout, parent, false)
        return MyViewHolder(view)
    }

    // Holder에 보관 중인 View에 원본 데이터 연결
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvText.text = list[position]
    }

    // 항목의 뷰를 생성한 후 멤버 변수를 보관하는 ViewHolder
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvText = view.findViewById<TextView>(R.id.tvText)
        init {
            /*view.setOnClickListener {
                Toast.makeText(view.context, "항목 $adapterPosition View 터치!", Toast.LENGTH_SHORT).show()
            }*/
            tvText.setOnLongClickListener {
                this@MyAdapter.list.removeAt(adapterPosition)
                notifyDataSetChanged()
                true
            }
        }
    }
    // this@MyAdapter가 MyViewHolder 안에서는 안됨
    // inner class 해줘야 가능
}