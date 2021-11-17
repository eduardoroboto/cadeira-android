package br.com.unifor.threeintents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class SoundActivity : AppCompatActivity() {

   private lateinit var buttonPlaySound: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sound)

        Log.i("App","[SoundActivity] - onCreat")

        buttonPlaySound = findViewById(R.id.button_playsound)

        buttonPlaySound.setOnClickListener {
            val webpage: Uri = Uri.parse("https://www.youtube.com/watch?v=DSxlxHzWG-M")
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }


    }
}