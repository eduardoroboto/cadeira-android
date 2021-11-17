package br.com.unifor.threeintents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var buttonCameraActivity: Button
    private lateinit var buttonSoundActivity: Button
    private lateinit var buttonMapActivity: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCameraActivity = findViewById(R.id.button_cameraactivity)
        buttonSoundActivity = findViewById(R.id.button_soundactivity)
        buttonMapActivity = findViewById(R.id.button_mapactivity)

        buttonCameraActivity.setOnClickListener(this)
        buttonSoundActivity.setOnClickListener(this)
        buttonMapActivity.setOnClickListener(this)


        Log.i("App","[MainActivity] - onCreat")

    }

    override fun onClick(view: View?) {

        when(view?.id){

            R.id.button_cameraactivity ->{
                val it = Intent(this, CameraActivity::class.java)
                startActivity(it)
            }
            R.id.button_soundactivity ->{
                val it = Intent(this, SoundActivity::class.java)
                startActivity(it)
            }
            R.id.button_mapactivity ->{
                val it = Intent(this, MapActivity::class.java)
                startActivity(it)
            }
        }

    }

}