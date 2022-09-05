package com.example.ricknmortyhw

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ricknmortyhw.databinding.ItemRecyclerBinding
import java.util.ArrayList

class RnMAdapter(val data: ArrayList<RnM>,
val onClick:(name:String, status:String, img:Int) -> Unit)
: RecyclerView.Adapter<RnMAdapter.RnMViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RnMViewHolder {
        return RnMViewHolder(ItemRecyclerBinding.inflate(LayoutInflater
            .from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RnMViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = data.size



    inner class RnMViewHolder(private val binding: ItemRecyclerBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(){
            val item = data[adapterPosition]
            itemView.setOnClickListener {
                item.img?.let { it1 -> onClick(item.name.toString(), item.status.toString(), it1) }
            }
            item.img?.let { binding.imgItem.setImageResource(it) }
            binding.itemName.text = item.name
            binding.itemStatus.text = item.status
        }
    }
}