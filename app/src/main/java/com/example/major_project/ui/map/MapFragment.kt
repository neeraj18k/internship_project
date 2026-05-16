package com.example.major_project.ui.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.major_project.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add 5 inscriptions as required
        val inscriptions = listOf(
            Triple(12.9716, 77.5946, "Bangalore Inscription"),
            Triple(15.3350, 76.4600, "Hampi Stone"),
            Triple(15.7483, 75.6797, "Badami Inscription"),
            Triple(15.9189, 75.8239, "Aihole Tablet"),
            Triple(15.7410, 75.7594, "Pattadakal Law")
        )

        for (insc in inscriptions) {
            val marker = mMap.addMarker(MarkerOptions()
                .position(LatLng(insc.first, insc.second))
                .title(insc.third))
            marker?.tag = 1 // Simplified: all point to ID 1 for now
        }

        mMap.setOnMarkerClickListener { marker ->
            val id = marker.tag as? Int ?: 1
            val bundle = Bundle().apply {
                putInt("inscriptionId", id)
            }
            findNavController().navigate(R.id.inscriptionDetailFragment, bundle)
            true
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(inscriptions[0].first, inscriptions[0].second), 6f))
    }
}
