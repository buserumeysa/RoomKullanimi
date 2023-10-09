package com.example.roomkullanimi.ui.theme

import androidx.room.Dao
import androidx.room.Query

@Dao
interface KisilerDao {
    @Query("SELECT * FROM kisiler")
    suspend fun tumKisiler(): List<Kisiler>?
}