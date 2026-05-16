package com.example.major_project.ui.phototag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.major_project.R
import com.example.major_project.databinding.FragmentPhotoTagBinding

class PhotoTagFragment : Fragment() {

    private var _binding: FragmentPhotoTagBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPhotoTagBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCapture.setOnClickListener {
            // Mocking camera capture and decoding
            binding.progressBar.visibility = View.VISIBLE
            binding.tvStatus.text = "Decoding Inscription..."
            
            view.postDelayed({
                if (_binding != null) {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(context, "Inscription Identified!", Toast.LENGTH_SHORT).show()
                    val bundle = Bundle().apply {
                        putInt("inscriptionId", 1) // Default to Halmidi for demo
                    }
                    findNavController().navigate(R.id.inscriptionDetailFragment, bundle)
                }
            }, 2000)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
