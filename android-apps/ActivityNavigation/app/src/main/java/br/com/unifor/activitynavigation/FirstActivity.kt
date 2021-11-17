package br.com.unifor.activitynavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        Log.i("App","[FirstActivity] - onStart")
    }

    override fun onStart() {
        super.onStart()
        Log.i("App","[FirstActivity] - onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("App","[FirstActivity] - onRestart")
    }
    override fun onResume() {
        super.onResume()
        Log.i("App","[FirstActivity] - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("App","[FirstActivity] - onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.i("App","[FirstActivity] - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("App","[FirstActivity] - onDestroy")
    }
}