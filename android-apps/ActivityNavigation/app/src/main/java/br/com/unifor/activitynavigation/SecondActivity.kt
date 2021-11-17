package br.com.unifor.activitynavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.i("App","[SecondActivity] - onStart")
    }

    override fun onStart() {
        super.onStart()
        Log.i("App","[SecondActivity] - onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("App","[SecondActivity] - onRestart")
    }
    override fun onResume() {
        super.onResume()
        Log.i("App","[SecondActivity] - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("App","[SecondActivity] - onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.i("App","[SecondActivity] - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("App","[SecondActivity] - onDestroy")
    }
}