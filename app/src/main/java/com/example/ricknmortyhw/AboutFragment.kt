package com.example.ricknmortyhw

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ricknmortyhw.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {
    private lateinit var binding: FragmentAboutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments!=null){
            val name = arguments?.getString(RecyclerFragment.KEY_FOR_NAME)
            val status = arguments?.getString(RecyclerFragment.KEY_FOR_STATUS)
            val img = arguments?.getInt(RecyclerFragment.KEY_FOR_IMG)

            binding.aName.text = name
            binding.aStatus.text = status
            img?.let { binding.aImg.setImageResource(it) }

        }
    }

    companion object {

    }
}