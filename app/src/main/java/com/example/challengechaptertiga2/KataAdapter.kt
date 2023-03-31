package com.example.challengechaptertiga2

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challengechaptertiga2.databinding.ItemListkataBinding

class KataAdapter(var kataAdapter: ArrayList<DataKata>, var onItemClick: ((DataAbjad) -> Unit)? = null): RecyclerView.Adapter<KataAdapter.ViewHolder>(){
    class ViewHolder(var binding: ItemListkataBinding):RecyclerView.ViewHolder(binding.root) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KataAdapter.ViewHolder {
        val binding = ItemListkataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun getItemCount(): Int {
       return kataAdapter.size
    }

    override fun onBindViewHolder(holder: KataAdapter.ViewHolder, position: Int) {
        var a = kataAdapter[position].kata
        holder.binding.btnKata.setOnClickListener {
            val keyword = kataAdapter[position].kata
            val url = Intent(Intent.ACTION_VIEW)
            url.data = Uri.parse("https://www.google.com/search?q=$keyword")
            holder.binding.btnKata.context.startActivity(url)
        }
        holder.binding.btnKata.text = a
    }
}