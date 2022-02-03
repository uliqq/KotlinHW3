package com.geektech.kotlinhw3.ui.activities.second

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.kotlinhw3.databinding.ListItemBinding
import com.geektech.kotlinhw3.extensions.load
import com.geektech.kotlinhw3.models.Pictures

class SecondAdapter(private var list: ArrayList<Pictures>)
    : RecyclerView.Adapter<SecondAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    inner class ViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun onBind(pictures: Pictures) {
            binding.ivPictures.load(pictures.url)
        }
    }
}