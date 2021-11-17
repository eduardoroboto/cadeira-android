package br.com.unifor.threeintents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MapActivity : AppCompatActivity() {

    private lateinit var buttonShowMe: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        Log.i("App","[MapActivity] - onCreat")

        buttonShowMe = findViewById(R.id.button_buttobigben)
        buttonShowMe.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("geo:51.5007,-0.1245")
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }

    }
}