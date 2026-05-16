package com.example.major_project.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "inscriptions")
data class Inscription(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val dynasty: String,
    val location: String,
    val century: String,
    val description: String,
    val imageUrl: String? = null,
    val latitude: Double = 0.0,
    val longitude: Double = 0.0
)