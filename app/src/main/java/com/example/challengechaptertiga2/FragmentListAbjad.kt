@file:Suppress("UNREACHABLE_CODE")

package com.example.challengechaptertiga2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challengechaptertiga2.databinding.FragmentListAbjadBinding


class FragmentListAbjad : Fragment(){
    lateinit var binding: FragmentListAbjadBinding
    val kumpulanHuruf = ArrayList<DataAbjad>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentListAbjadBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.huruf.layoutManager = LinearLayoutManager(context)
        val kumpulanKataFrag = FragmentListKata()
        val listAbjadAdapter = AbjadAdapter(kumpulanHuruf)
        listAbjadAdapter.onItemClick = {

        }
        binding.huruf.adapter = listAbjadAdapter
        kumpulanHuruf.clear()
        kumpulanHuruf.addAll(getlisthuruf())
        getlisthuruf()



    }
    private fun getlisthuruf(): ArrayList<DataAbjad> {
        val dataNama = resources.getStringArray(R.array.data_abjad)
        val listHuruf = ArrayList<DataAbjad>()

        for (i in dataNama.indices) {
            val huruf = DataAbjad(dataNama[i])
            listHuruf.add(huruf)
        }
        return listHuruf
    }


}




