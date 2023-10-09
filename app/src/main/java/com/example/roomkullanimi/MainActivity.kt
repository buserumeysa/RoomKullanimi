package com.example.roomkullanimi

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.roomkullanimi.ui.theme.RoomKullanimiTheme
import com.example.roomkullanimi.ui.theme.Veritabani
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomKullanimiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Sayfa()
                }
            }
        }
    }
}

@Composable
fun Sayfa() {
    val context = LocalContext.current
    val vt = Veritabani.veritabaniErisim(context)!!
    LaunchedEffect(key1 = true) {
        tumKisiler(vt)

    }

}

fun tumKisiler(vt: Veritabani) {
       CoroutineScope(Dispatchers.Main).launch {
        val liste = vt.kisilerDao().tumKisiler()


        for (k in liste.orEmpty()) {
            Log.e("Kisiler", "*************************************")
            Log.e("KisiId", k.kisi_id.toString())
            Log.e("kisiAdi", k.kisi_adi)
            Log.e("KisiTel", k.kisi_tel)

        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RoomKullanimiTheme {
        Sayfa()
    }
}