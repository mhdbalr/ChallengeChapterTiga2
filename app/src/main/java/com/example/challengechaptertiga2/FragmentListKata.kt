package com.example.challengechaptertiga2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challengechaptertiga2.databinding.FragmentListKataBinding



@Suppress("DEPRECATION")
class FragmentListKata() : Fragment() {
    lateinit var binding: FragmentListKataBinding
    val kumpulanKata = ArrayList<DataKata>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentListKataBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.kata.layoutManager = LinearLayoutManager(context)
        val listKataAdapter = KataAdapter(kumpulanKata)
        listKataAdapter.onItemClick = {
            val pindahweb = Intent(Intent.ACTION_VIEW)
            pindahweb.data = Uri.parse("https://www.google.com/search?q=${getlisthuruf()}")
        }
        getlisthuruf()
        binding.kata.adapter = listKataAdapter
        kumpulanKata.clear()
        kumpulanKata.addAll(getlisthuruf())



    }
    private fun getlisthuruf(): ArrayList<DataKata>{
        val args = this.arguments
        val data = args?.get("HURUF")
        val kata = resources.getStringArray(R.array.word)
        val getDataKata = ArrayList<DataKata>()
            for(i in kata.indices){
                val indexpertama = kata[i].take(1)
                if (indexpertama == data){
                    val dataKata = DataKata(kata[i])
                    getDataKata.add(dataKata)
                }
            }
        return getDataKata
    }

}






