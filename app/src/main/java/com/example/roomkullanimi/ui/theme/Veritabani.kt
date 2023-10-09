package com.example.roomkullanimi.ui.theme

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Kisiler::class], version = 1,exportSchema = false)
abstract class Veritabani : RoomDatabase() {
    abstract fun kisilerDao(): KisilerDao

    companion object {
        @Volatile
        var INSTANCE: Veritabani? = null

        @Synchronized
        fun veritabaniErisim(context: Context): Veritabani? {
            if (INSTANCE == null) {

                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    Veritabani::class.java,
                    "rehber.db"
                ).createFromAsset("rehber.db").build()


            }
            return INSTANCE
        }
    }
}