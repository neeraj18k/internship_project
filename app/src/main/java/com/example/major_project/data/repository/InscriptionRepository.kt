package com.example.major_project.data.repository

import com.example.major_project.data.model.Inscription

class InscriptionRepository {
    private val mockInscriptions = listOf(
        Inscription(
            1, "Halmidi Inscription", "Kadamba", "Halmidi", "5th Century",
            "This stone records a land gift by the Kadamba dynasty. It is the earliest known Kannada inscription.",
            null, 13.123, 75.123
        ),
        Inscription(
            2, "Badami Cliff Inscription", "Chalukya", "Badami", "6th Century",
            "Detailed record of the achievements of Pulakeshin I.",
            null, 15.123, 75.123
        )
    )

    fun getInscription(id: Int): Inscription? = mockInscriptions.find { it.id == id }
    fun getAll(): List<Inscription> = mockInscriptions
    
    fun getKannadaTranslation(id: Int): String {
        return when(id) {
            1 -> "ಈ ಶಾಸನವು ಕದಂಬ ರಾಜವಂಶವು ನೀಡಿದ ಭೂದಾನವನ್ನು ದಾಖಲಿಸುತ್ತದೆ. ಇದು ಅತ್ಯಂತ ಹಳೆಯ ಕನ್ನಡ ಶಾಸನವಾಗಿದೆ."
            2 -> "ಇದು ಮೊದಲನೇ ಪುಲಕೇಶಿಯ ಸಾಧನೆಗಳ ವಿವರವಾದ ದಾಖಲೆಯಾಗಿದೆ."
            else -> "ಮಾಹಿತಿ ಲಭ್ಯವಿಲ್ಲ."
        }
    }
}
