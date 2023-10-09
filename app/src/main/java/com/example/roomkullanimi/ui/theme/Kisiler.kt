package com.example.roomkullanimi.ui.theme

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kisiler")
data class Kisiler(
    @PrimaryKey(autoGenerate = true)
    var kisi_id: Int,
    var kisi_adi: String,
    var kisi_tel: String,
) {

}