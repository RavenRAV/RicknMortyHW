package com.example.ricknmortyhw

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.ricknmortyhw.databinding.FragmentRecyclerBinding

class RecyclerFragment : Fragment() {
    private val data = arrayListOf<RnM>()
    private lateinit var binding: FragmentRecyclerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecyclerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadData()
        val adapter = RnMAdapter(data, this::onClick)
        binding.recycler.adapter = adapter
    }

    private fun onClick(name:String, status: String, img: Int){
        Toast.makeText(requireContext(), name, Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.aboutFragment,
        bundleOf(KEY_FOR_NAME to name, KEY_FOR_STATUS to status, KEY_FOR_IMG to img))
    }

    private fun loadData() {
        data.add(RnM("Rick Sanchez", "Alive", R.drawable.rick))
        data.add(RnM("Morty Smith", "Alive", R.drawable.morty))
        data.add(RnM("Albert Einstein", "Dead", R.drawable.einstein))
        data.add(RnM("Jerry Smith", "Alive", R.drawable.jerry))
    }


    companion object {
        const val KEY_FOR_NAME = "key.name"
        const val KEY_FOR_STATUS = "key.status"
        const val KEY_FOR_IMG = "key.img"
    }
}