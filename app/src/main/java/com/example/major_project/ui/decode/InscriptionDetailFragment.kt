package com.example.major_project.ui.decode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.major_project.data.repository.InscriptionRepository
import com.example.major_project.databinding.FragmentInscriptionDetailBinding

class InscriptionDetailFragment : Fragment() {

    private var _binding: FragmentInscriptionDetailBinding? = null
    private val binding get() = _binding!!
    private val repository = InscriptionRepository()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInscriptionDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        val inscriptionId = arguments?.getInt("inscriptionId") ?: 1
        val inscription = repository.getInscription(inscriptionId)
        val translation = repository.getKannadaTranslation(inscriptionId)

        inscription?.let {
            binding.tvTitle.text = it.title
            binding.tvDynasty.text = it.dynasty
            binding.tvDescription.text = it.description
            binding.tvTranslationKannada.text = translation
        }

        binding.btnReportDamage.setOnClickListener {
            android.widget.Toast.makeText(context, "Preservation Alert Reported to Authorities!", android.widget.Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
