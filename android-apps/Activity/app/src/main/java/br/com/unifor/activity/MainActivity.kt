package br.com.unifor.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("App","OnCreate")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("App","OnRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.i("App","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("App","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("App","onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.i("App","onStop")


    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("App","onDestroy")
    }

}