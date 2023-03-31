package com.example.challengechaptertiga2


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.challengechaptertiga2.databinding.ItemListabjadBinding


class AbjadAdapter(var listHuruf: ArrayList<DataAbjad>, var onItemClick: ((DataAbjad) -> Unit)? = null): RecyclerView.Adapter<AbjadAdapter.ViewHolder>() {
    class ViewHolder(var binding: ItemListabjadBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListabjadBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var a = listHuruf[position].abjadd
        holder.binding.btnAbjad.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                val transaction = p0?.context as AppCompatActivity
                val bundle = Bundle()
                bundle.putString("HURUF", a)

                val kumpulanKataFrag = FragmentListKata()
                kumpulanKataFrag.arguments = bundle
                transaction.supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, kumpulanKataFrag)
                    .addToBackStack(null)
                    .commit()
            }
        })

        holder.binding.btnAbjad.text = a
    }


    override fun getItemCount(): Int {
        return listHuruf.size
    }

}






