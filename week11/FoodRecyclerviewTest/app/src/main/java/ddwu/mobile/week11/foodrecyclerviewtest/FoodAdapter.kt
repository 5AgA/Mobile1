package ddwu.mobile.week11.foodrecyclerviewtest

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ddwu.mobile.week11.foodrecyclerviewtest.databinding.ListItemBinding

class FoodAdapter (val foods: ArrayList<FoodDto>) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder> (){

    override fun getItemCount() = foods.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val itemBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.itemBinding.ivPhoto.setImageResource( foods[position].photo )
        holder.itemBinding.tvFood.text = foods[position].food
        holder.itemBinding.tvCount.text = foods[position].count.toString()   // int 타입이여서 형변환 id로 착각
    }

    inner class FoodViewHolder(val itemBinding: ListItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        val TAG = "FoodViewHolder"
        init {
            itemBinding.root.setOnClickListener {
                //Log.d(TAG, "${foods[adapterPosition]}")
                listener.onItemClick(it, adapterPosition)
            }

            itemBinding.root.setOnLongClickListener {
                listener2.onItemLongClick(it, adapterPosition)
                true
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int) : Unit
    }

    interface OnItemLongClickListener {
        fun onItemLongClick(view: View, position: Int) : Boolean
    }

    lateinit var listener: OnItemClickListener
    lateinit var listener2: OnItemLongClickListener

    fun setOnItemClickListener (listener: OnItemClickListener) {
        this.listener = listener
    }

    fun setOnItemLongClickListener (listener: OnItemLongClickListener) {
        this.listener2 = listener
    }
}