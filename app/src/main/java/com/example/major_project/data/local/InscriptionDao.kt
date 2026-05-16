package com.example.major_project.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.major_project.data.model.Inscription
import kotlinx.coroutines.flow.Flow

@Dao
interface InscriptionDao {
    @Query("SELECT * FROM inscriptions ORDER BY id DESC")
    fun getAllInscriptions(): Flow<List<Inscription>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInscription(inscription: Inscription)

    @Query("SELECT * FROM inscriptions WHERE id = :id")
    suspend fun getInscriptionById(id: Int): Inscription?
}