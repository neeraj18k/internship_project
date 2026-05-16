package com.example.major_project.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.major_project.R
import com.example.major_project.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        binding.cardFindShasane.setOnClickListener {
            findNavController().navigate(R.id.mapFragment)
        }
        
        binding.cardHistoryQuiz.setOnClickListener {
            findNavController().navigate(R.id.quizFragment)
        }
        
        binding.cardPhotoTag.setOnClickListener {
            findNavController().navigate(R.id.photoTagFragment)
        }
        
        binding.cardAIDecode.setOnClickListener {
            // Navigate to detail for Halmidi as an example
            val bundle = Bundle().apply {
                putInt("inscriptionId", 1)
            }
            findNavController().navigate(R.id.inscriptionDetailFragment, bundle)
        }
        
        // Setup other features
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
